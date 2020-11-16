package com.example.roomtest

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(version = 1, entities = arrayOf(User::class))
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): MyUserDao//最终要调用的, 得到Dao

    companion object {

        private var instance: AppDatabase? = null

        @Synchronized//单例
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it //返回的是外层
            }//目标返回对象
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "myDatabase"
            ).allowMainThreadQueries().build().apply {
                instance = this
            }
        }
    }
}
