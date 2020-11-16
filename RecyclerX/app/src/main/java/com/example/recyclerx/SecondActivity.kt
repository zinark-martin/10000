package com.example.recyclerx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.bindScope
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.ext.scope

class SecondActivity : AppCompatActivity() {
    private val girl by inject<Girl>()
    private val girls by inject<Girl> (named("123"))
    private val girl1 by inject<Girl>(named("one")) { parametersOf("lily")}
    private val girl2 by inject<Girl>(named("two")) { parametersOf("kit") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        imageView.setImageResource(R.drawable.ic_launcher_background)
        //view's fun
        imageView.postDelayed(
            { imageView.setImageResource(R.drawable.ic_launcher_background) },
            3000
        )
        //scope 只在绑定的范围内(this销毁前)起作用
        val scope1 = getKoin().createScope("scope1", named("scope"))
        bindScope(scope1)
        scope1.get<Girl>().name = "new name"
        startActivity(Intent(this, ThirdActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        val name = getKoin().getScope("scope1").get<Girl>().name
    }
}