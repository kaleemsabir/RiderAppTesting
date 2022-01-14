package com.barfeemart.riderapp.ui.orderTab

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.constants.pageSize
import com.barfeemart.riderapp.data.news.NewsResponse
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.util.EncryptSharedPref
import androidx.viewpager.widget.ViewPager

import androidx.databinding.BindingAdapter
import com.barfeemart.riderapp.base.BaseActivity


class TabViewModel(
    private val allNewsRepository: AllNewsRepository,
    private val sharedPreferences: EncryptSharedPref,
    ) : BaseViewModel() {



    fun navigateToHome(view: View){
        Navigation.findNavController(view).navigate(R.id.actionOrderListing)
    }

}