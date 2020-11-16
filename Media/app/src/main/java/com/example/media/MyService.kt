package com.example.media

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MyService : Service() {

    //继承自Binder
    class DownLoadBinder : Binder() {
        //下载和获取进展的函数
        fun startDownLoad() {
        }

        fun getProcess(): Int {
            return 0
        }
    }

    //实例对象
    private val mBinder = DownLoadBinder()

    override fun onCreate() {
        super.onCreate()
//        val notificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(
//            NotificationChannel(
//                "通知1号",
//                "通知",
//                NotificationManager.IMPORTANCE_HIGH
//            )
//        )
        val intent = Intent(this, notification::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "通知1号")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText("123").setContentTitle("通知").setContentIntent(pi)
            .setVibrate(longArrayOf(100, 50, 100, 0, 50, 100)).build()
        //notificationManager.notify(1, notification)
        startForeground(1,notification)//不需要manager, 这是service的方法
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }
}
