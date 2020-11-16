package com.example.media

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var downLoadBinder: MyService.DownLoadBinder
    //可以在activity中调用其任何public方法
    //downLoadBinder.startDownLoad()

    //serviceConnection的匿名类实现, 重写绑定后和解绑后执行的方法
    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            downLoadBinder = service as MyService.DownLoadBinder
            downLoadBinder.apply {
                startDownLoad()
                getProcess()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serIntent = Intent(this, MyService::class.java)
        StartService.setOnClickListener {
            startService(serIntent)// 开始service
        }
        StopService.setOnClickListener {
            stopService(serIntent)// 停止service
        }
        lifecycle.addObserver(Life())
        Bind.setOnClickListener {
            //绑定, 和service进行通信. 会调用service的onBind方法
            bindService(serIntent,connection,Context.BIND_AUTO_CREATE)
        }
        unBind.setOnClickListener {
            unbindService(connection)
        }
    }
}