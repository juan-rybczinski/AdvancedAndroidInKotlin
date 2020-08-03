Summary
============================================================================

- Use the [NotificationManager](https://developer.android.com/reference/android/app/NotificationManager) class to create, send, update, and cancel a notification using.
- Use a [NotificationChannel](https://developer.android.com/reference/android/app/NotificationChannel.html) object with the [createNotificationChannel](https://developer.android.com/reference/android/app/NotificationManager#createNotificationChannel(android.app.NotificationChannel)) method to set a channel for the notification.
- Use [addAction()](https://developer.android.com/reference/androidx/core/app/NotificationCompat.Builder.html#addAction(android.support.v4.app.NotificationCompat.Action)) to add quick actions to a notification.
- Use [setShowBadge()](https://developer.android.com/reference/android/app/NotificationChannel.html#setShowBadge(boolean)) to enable or disable badges,.
- Style your notifications using styles which extends from [Notification.Style](https://developer.android.com/reference/android/app/Notification.Style.html)
- Set the importance level with [NotificationChannel.setImportance()](https://developer.android.com/reference/android/app/NotificationChannel#setImportance(int))
- Implement a FCM BroadcastReceiver by extending [`FirebaseMessagingService`](https://firebase.google.com/docs/reference/android/com/google/firebase/messaging/FirebaseMessagingService).
- Set up a [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging) (FCM) project and add FCM to your Android app.
- Test your app by sending push notifications from the Notifications composer.
- Subscribe to FCM [topic](https://firebase.google.com/docs/cloud-messaging/android/topic-messaging#subscribe_the_client_app_to_a_topic)s by calling the [`subscribeToTopic()`](https://firebase.google.com/docs/reference/android/com/google/firebase/messaging/FirebaseMessaging.html#subscribeToTopic(java.lang.String)) function of the [`FirebaseMessaging`](https://firebase.google.com/docs/reference/android/com/google/firebase/messaging/FirebaseMessaging) class.
- Send a data payload using a [`RemoteMessage`](https://firebase.google.com/docs/reference/android/com/google/firebase/messaging/RemoteMessage) object.
- Handle data in the [`onMessageReceived()`](https://firebase.google.com/docs/cloud-messaging/android/receive#override-onmessagereceived)function.
- Add logic to handle FCM when the app is in the foreground and when it's in the background.

### FirebaseMessagingService

- `onNewToken()`—Called automatically if your service is registered in the Android manifest. This function is called when you first run your app and every time Firebase issues a new *token* for your app. A token is an access key to your Firebase backend project. It's generated for your specific client device. With this token, Firebase knows which client the backend should send messages to. Firebase also knows if this client is valid and has access to this Firebase project.
- `onMessageReceived`— Called when your app is running and Firebase sends a message to your app. This function receives a [`RemoteMessage`](https://firebase.google.com/docs/reference/android/com/google/firebase/messaging/RemoteMessage) object which, can carry a notification or data message payload.

> **Note:** Optionally, if you have a separate backend project, you may want to store this client token in order to send individual messages to this client. In that case, you need to call your backend to save this token immediately after receiving a new token.. The backend service can be on Firebase or could be any other backend service. In the sample code you are given an empty function named `sendRegistrationToServer()` which is called after receiving a new token. You can use this function to send this token to the backend of your choice.

### Topic

FCM topic messaging is based on the publish/subscribe model.

A messaging app can be a good example for the **Publish/Subscribe** model. Imagine that an app checks for new messages every 10 seconds. This will not only drain your phone battery, but will also use unnecessary network resources, and will create an unnecessary load on your app's server. Instead, a client device can subscribe and be notified when there are new messages delivered through your app.

**Topics** allow you to send a message to multiple devices that have opted in to that particular topic. For clients, topics are specific data sources which the client is interested in. For the server, topics are groups of devices which have opted in to receive updates on a specific data source. Topics can be used to present categories of notifications, such as news, weather forecasts, and sports results.

### Data Payload

> **Note:** The maximum payload size for both message types is 4 KB (except when sending messages from the Firebase console, which enforces a 1024-character limit).

### Handling messages in the foreground and background

When a client device running your app receives a message that includes both notification and data payloads, the app's behavior depends on whether your app is in the background or the foreground on that device:

- If the app is running the background, if the message has a notification payload, the notification is automatically shown in the notification tray. If the message also has a data payload, the data payload will be handled by the app when the user taps on the notification.
- If the app is running in the foreground, if the message notification has a notification payload, the notification will not appear automatically. The app needs to decide how to handle the notification in the `onMessageReceived()` function. If the message also has data payload, both payloads will be handled by the app.