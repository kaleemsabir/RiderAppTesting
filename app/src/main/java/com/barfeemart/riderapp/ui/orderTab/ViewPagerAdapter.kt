package com.barfeemart.riderapp.ui.orderTab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.barfeemart.riderapp.ui.orderlistingongoing.OrderListingOnGoing

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm)  {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return OrderListingOnGoing()
            }
            else -> {
                return OrderListingOnGoing()
            }

        }
    }
}