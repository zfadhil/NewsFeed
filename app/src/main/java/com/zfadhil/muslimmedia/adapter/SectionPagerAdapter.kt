package com.zfadhil.muslimmedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zfadhil.muslimmedia.fragment.AboutAlQuranFragment
import com.zfadhil.muslimmedia.fragment.AlJazeeraFragment
import com.zfadhil.muslimmedia.fragment.CommonFragment
import com.zfadhil.muslimmedia.fragment.WarningFragment

class SectionPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()
            else -> CommonFragment()
        }
    }
}