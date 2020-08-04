package com.example.navgtvpager

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //每个navHost都有相应自己的NavController
        //1.
        nav_host_fragment.findNavController()
        Fragment().findNavController()
        //2.
        Activity().findNavController(R.id.nav_host_fragment)

        //您可以使用全局操作来创建多个目的地可以使用的常见操作。例如，您可能想要在不同的目的地中使用能够导航到同一应用主屏幕的按钮。
        globalTransButton.setOnClickListener {
            nav_host_fragment.findNavController().navigate(R.id.action_global_mainFragment)
            Fragment().findNavController().popBackStack()
        }
        
        //也可以使用这个Navigation类提供的方法, 就是把点击的匿名内部类做了一个封装
        globalTransButton.setOnClickListener(Navigation
            .createNavigateOnClickListener(R.id.action_thirdFragment_to_mainFragment))
    }
}