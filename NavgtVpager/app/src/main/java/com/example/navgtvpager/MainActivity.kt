package com.example.navgtvpager

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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
    }
}