package com.example.viewtouch

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
            ARouter.printStackTrace()
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }
}