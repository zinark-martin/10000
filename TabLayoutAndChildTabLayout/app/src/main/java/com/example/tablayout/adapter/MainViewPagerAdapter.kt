package com.example.tablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tablayout.fragment.ChildFragment
import com.example.tablayout.fragment.MessageFragment
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

class MainViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_SET_USER_VISIBLE_HINT)
{
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChildFragment.newInstance("HOME")
            1 -> MessageFragment()
            else -> ChildFragment.newInstance("PERSON")
        }
    }
    override fun getCount(): Int = 3

}