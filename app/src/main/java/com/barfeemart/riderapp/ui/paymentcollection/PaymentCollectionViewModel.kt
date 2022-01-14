package com.barfeemart.riderapp.ui.paymentcollection

import android.view.View
import androidx.navigation.Navigation
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.util.EncryptSharedPref

class PaymentCollectionViewModel(
    private val allNewsRepository: AllNewsRepository,
    private val sharedPreferences: EncryptSharedPref,
) : BaseViewModel() {


}