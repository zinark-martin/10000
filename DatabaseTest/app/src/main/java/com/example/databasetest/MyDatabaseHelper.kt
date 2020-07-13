package com.example.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.*
import java.util.logging.Handler
import kotlin.concurrent.thread

class MyDatabaseHelper(val context: Context, name: String, version: Int): SQLiteOpenHelper(context, name, null, version) {
    private val createBook =
        "create table Book (" + "id integer primary key autoincrement, " +
                "author text, " +
                "price real, " +
                "pages integer, " +
                "name text)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        Toast.makeText(context, "yo", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, v1: Int, v2: Int) {
    }
}

class Coroutine(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override val coroutineContext = Dispatchers.IO

    override suspend fun doWork(): Result = coroutineScope {
        val jobs = (0 until 100).map {
            async {
            }
        }
        jobs.awaitAll()
        Result.success()
    }
}
