package com.example.media

import android.app.IntentService
import android.content.Intent
import android.content.Context

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
