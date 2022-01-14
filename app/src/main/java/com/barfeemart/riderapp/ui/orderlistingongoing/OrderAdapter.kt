package com.barfeemart.riderapp.ui.orderlistingongoing

import android.util.Log
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseAdapter
import com.barfeemart.riderapp.base.BaseViewHolder
import com.barfeemart.riderapp.data.orders.Order
import com.barfeemart.riderapp.databinding.OrdersItemBinding

class OrderAdapter(private val clickListener: (result: Order) -> Unit) :
    BaseAdapter<OrdersItemBinding>() {
    init {
        // auto called after constructor
        addData(ArrayList<Order>())
    }
    fun addOrderList(data:List<Order>){
     data.let {
         addData(it)
         notifyDataSetChanged()
     }
        Log.d("dummydatadsdAdapeter",data.toString());

    }
    override fun viewHolder(
        layout: Int,
        binding: OrdersItemBinding
    ): BaseViewHolder<OrdersItemBinding> {
       return OrderViewHolder(binding,clickListener)
    }

    override fun layout(position: Int): Int {
       return R.layout.orders_item
    }
}