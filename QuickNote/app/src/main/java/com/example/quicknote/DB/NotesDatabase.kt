package com.example.quicknote.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quicknote.Model.Notes


@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase()  {
    abstract fun getNotesDao(): NotesDao

    companion object {
        @Volatile
        private var instance: NotesDatabase? = null

        @Synchronized
        operator fun invoke(context: Context): NotesDatabase = instance ?:
        Room.databaseBuilder(
            context.applicationContext,
            NotesDatabase::class.java,
            "笔记数据库"
        ).build().also { instance = it }
    }
}