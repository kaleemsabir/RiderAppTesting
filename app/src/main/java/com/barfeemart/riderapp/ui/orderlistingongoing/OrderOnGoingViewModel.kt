package com.barfeemart.riderapp.ui.orderlistingongoing

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.data.news.NewsResponse
import com.barfeemart.riderapp.data.orders.Order
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.util.EncryptSharedPref

class OrderOnGoingViewModel(
    private val allNewsRepository: AllNewsRepository,
    private val sharedPreferences: EncryptSharedPref
) : BaseViewModel() {
     var _allOrderLiveData: MutableLiveData<List<Order>> = MutableLiveData()


    fun setDummyData() {
        val order: ArrayList<Order> = ArrayList()
        order.add(Order("Order # 1464", "High Q Tower Lahore ", "1:00 PM"))
        order.add(Order("Order # 6464", "Kalma Chowk Lahore ", "2:00 PM"))
        order.add(Order("Order # 4875", "High Q Tower Lahore ", "3:00 PM"))
        order.add(Order("Order # 789413", "High Q Tower Lahore ", "4:00 PM"))
        _allOrderLiveData.value = order
        Log.d("dummydatadsd",_allOrderLiveData.value.toString());

    }
}