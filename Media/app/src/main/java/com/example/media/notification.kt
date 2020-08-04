package com.example.media

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class notification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val notificationManager2 =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager2.cancel(1)
    }
}