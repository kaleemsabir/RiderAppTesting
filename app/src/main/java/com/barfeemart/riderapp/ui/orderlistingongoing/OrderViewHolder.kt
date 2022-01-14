package com.barfeemart.riderapp.ui.orderlistingongoing

import android.view.View
import com.barfeemart.riderapp.base.BaseViewHolder
import com.barfeemart.riderapp.data.orders.Order
import com.barfeemart.riderapp.databinding.OrdersItemBinding

class OrderViewHolder(
    view: OrdersItemBinding, val clickListener: (result: Order) -> Unit
) : BaseViewHolder<OrdersItemBinding>(view) {
    private lateinit var  order: Order
    override fun bindData(data: Any, position: Int) {
       if(data is Order){
           order = data
           binding().data = order
       }
    }

    override fun onClick(p0: View?) {
        clickListener(order)
    }

    override fun onLongClick(p0: View?): Boolean {
        return false
    }
}