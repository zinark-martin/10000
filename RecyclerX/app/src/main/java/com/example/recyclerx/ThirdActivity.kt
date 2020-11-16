package com.example.recyclerx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.getKoin
import org.koin.ext.scope

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val scope1 = getKoin().getScope("scope1").get<Girl>().apply {
            name = "new new name"
        }

    }
}