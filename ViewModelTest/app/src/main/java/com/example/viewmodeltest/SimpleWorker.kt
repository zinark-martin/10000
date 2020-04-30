package com.example.viewmodeltest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
//继承worker并调用其唯一的构造器
class SimpleWorker (context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("SimpleWorker", "do work in SimpleWorker")
        return Result.success()
    }
}