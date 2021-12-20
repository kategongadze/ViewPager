package com.example.viewpagernew.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagernew.fragments.FirstFragment
import com.example.viewpagernew.fragments.FourthFragment
import com.example.viewpagernew.fragments.SecondFragment
import com.example.viewpagernew.fragments.ThirdFragment

class ViewPagerFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            else -> FirstFragment()
        }
    }
}