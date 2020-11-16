package com.example.media

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Life : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun serviceStart() {
        Log.d("服务", "服务开始")
    }
}