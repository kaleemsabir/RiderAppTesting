package com.barfeemart.riderapp.ui.newsdetails

import android.os.Bundle
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentNewsDetailsBinding

/**
@author Salman Aziz
created on 2/22/21
 **/


class NewsDetailsFragment : BaseFragment<FragmentNewsDetailsBinding>() {
//
//      val news by lazy {
//          NewsDetailsFragmentArgs.fromBundle(requireArguments()).news
//      }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    //    binding.data=news
     }

    override fun getLayoutId()=R.layout.fragment_news_details



    override fun getViewModel() : BaseViewModel? = null


    override fun initFragment() {
         binding.lifecycleOwner=this
    }


}