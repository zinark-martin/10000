package com.example.tablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tablayout.fragment.ChildFragment

/**
 * 消息页面ViewPager的Adapter
 */
class MFragmentViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(
    manager,
    BEHAVIOR_SET_USER_VISIBLE_HINT
) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChildFragment.newInstance("first")
            1 -> ChildFragment.newInstance("second")
            2 -> ChildFragment.newInstance("third")
            else -> ChildFragment.newInstance("last")
        }
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence? {
        //不管大小写都会给你转大写:)
        return when (position) {
            0 -> "first"
            1 -> "second"
            2 -> "third"
            else -> "last"
        }
    }
}