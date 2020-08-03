package com.example.android.eggtimernotifications

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService(){

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "From: ${remoteMessage?.from}")
    }

    override fun onNewToken(token: String?) {
        Log.d(TAG, "Refreshed token: $token")

        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String?) {
//        TODO("Not yet implemented")
    }

    companion object {
        private val TAG = MyFirebaseMessagingService::class.java.simpleName
    }

}