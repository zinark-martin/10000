package com.example.viewmodeltest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(version = 1, entities = [User::class])

//必须继承自RoomDatabase
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var theInstance: AppDatabase? = null

        @Synchronized //保证单例模式的线程安全
        fun getDatabase(context: Context): AppDatabase {
            // "?." 表示object不为null的条件下，才会去执行let函数体
            theInstance?.let {
                return it
            }
            //返回Room ...build 并将其引用赋给instance
            return Room.databaseBuilder(context.applicationContext
                    , AppDatabase::class.java, "app_database").build()
                .apply {
                    theInstance = this
                }
        }
    }
}