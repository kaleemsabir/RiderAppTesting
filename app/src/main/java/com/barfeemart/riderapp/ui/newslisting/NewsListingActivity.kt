package com.barfeemart.riderapp.ui.newslisting

import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseActivity
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.ActivityMainBinding

/**
@author Salman Aziz
created on 2/22/21
 **/

class NewsListingActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewModel(): BaseViewModel? {
         return null
    }

    override fun hasConnectivity(connectivity: Boolean) {
        if (!connectivity)
            noConnectivity()
    }


    override fun getLayoutId() = R.layout.activity_main

    override fun getNavHostId(): Int {
      return R.id.nav_host_fragment
    }
}