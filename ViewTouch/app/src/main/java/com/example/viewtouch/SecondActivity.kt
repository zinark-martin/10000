package com.example.viewtouch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = "/app/SecondActivity.kt")
class SecondActivity : AppCompatActivity() {
    @JvmField
    @Autowired
    var 天气 = "🌤"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageView2.setImageResource(R.drawable.pic1)
        imageView2.transitionName = "iv"

        ARouter.getInstance().inject(this)
        val weather = intent.getStringExtra("天气")
        val extraDate = intent.extras?.getInt("日期",1970)
        Toast.makeText(this, weather, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "$extraDate", Toast.LENGTH_SHORT).show()
    }
}