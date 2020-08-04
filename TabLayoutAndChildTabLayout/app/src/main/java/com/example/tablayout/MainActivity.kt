package com.example.tablayout

import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.adapter.MainViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.selects.select
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainAdapter = MainViewPagerAdapter(supportFragmentManager)
        viewPager.apply {
            //setAdapter
            adapter = mainAdapter
            //set缓存页数
            offscreenPageLimit = 1
        }

        //没有类似setUpWithViewPager(vp)的方法, 而是以这种选择item后使vp做出换页的方式
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    viewPager.currentItem = 0
                }
                R.id.nav_message -> {
                    viewPager.currentItem = 1
                }
                R.id.nav_person -> {
                    viewPager.currentItem = 2
                }
            }
            true
        }
        //不使用kotlin语法糖, 看得更清楚
//        bottomNavigationView.setOnNavigationItemReselectedListener(object : BottomNavigationView.OnNavigationItemReselectedListener{
//            override fun onNavigationItemReselected(p0: MenuItem) {
//                //根据menu的itemId, 调用viewpager的方法使切换页面
//                when (p0.itemId) {
//                    R.id.nav_home ->
//                        viewPager.currentItem = 0
//                    R.id.nav_message ->
//                        viewPager.currentItem = 1
//                    R.id.nav_person ->
//                        viewPager.currentItem = 2
//                }
//            }
//        })
    }
}