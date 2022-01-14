package com.barfeemart.riderapp.ui.orderdetail

import android.view.View
import androidx.navigation.Navigation
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.util.EncryptSharedPref

class OrderDetailViewModel(private val allNewsRepository: AllNewsRepository,
                           private val sharedPreferences: EncryptSharedPref
):BaseViewModel() {
    fun moveToPaymentCollection(view: View) {
        Navigation.findNavController(view).navigate(R.id.actionPaymentCollection)
    }
}