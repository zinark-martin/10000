package com.example.tablayout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.transaction
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.R
import com.example.tablayout.adapter.MFragmentViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_message.*

/**
 * 消息Fragment
 */
class MessageFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //在activityCreated时初始化vp的adapter
        val secondAdapter = MFragmentViewPagerAdapter(childFragmentManager)
        viewPager.apply {
            adapter = secondAdapter
            offscreenPageLimit = 1
//            addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
//                override fun onPageScrollStateChanged(state: Int) {
//                    //看源码文档
//                }
//
//                override fun onPageScrolled(
//                    position: Int,
//                    positionOffset: Float,
//                    positionOffsetPixels: Int
//                ) {
//                    //同上 :)
//                }
//
//                override fun onPageSelected(position: Int) {
//                }
//
//            })
        }
        tabLayout.apply {
            setupWithViewPager(viewPager)
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                override fun onTabReselected(p0: TabLayout.Tab?) {
                    //Toast.makeText(activity,"I'm back bitch", Toast.LENGTH_SHORT).show()
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {
                    //Toast.makeText(activity,"see you~", Toast.LENGTH_SHORT).show()
                }

                override fun onTabSelected(p0: TabLayout.Tab?) {
                    Toast.makeText(activity, p0?.text, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}