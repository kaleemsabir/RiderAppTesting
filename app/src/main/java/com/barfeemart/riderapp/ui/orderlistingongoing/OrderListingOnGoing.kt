package com.barfeemart.riderapp.ui.orderlistingongoing

import android.os.Bundle
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentOrderListingOnGoingBinding
import com.barfeemart.riderapp.ui.newsdetails.NewsDetailsFragmentArgs
import com.barfeemart.riderapp.ui.orderdetail.OrderDetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrderListingOnGoing : BaseFragment<FragmentOrderListingOnGoingBinding>(){
   private val viewModel by viewModel<OrderOnGoingViewModel>()
    private val orderAdapter by lazy {
        OrderAdapter { order ->
            val bundle = Bundle()
            bundle.putParcelable("order", order)
            val args = OrderDetailFragmentArgs.fromBundle(bundle)
            navigateToDestination(R.id.actionOrderDetail, args.toBundle())
        }
    }
    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun initFragment() {
        viewModel.setDummyData()
        if (binding.lifecycleOwner == null) {
            binding.apply {
                lifecycleOwner = this@OrderListingOnGoing
                viewModel = this@OrderListingOnGoing.viewModel
                adapter = orderAdapter
            }
        }
    }

    override fun getLayoutId(): Int {
     return R.layout.fragment_order_listing_on_going
    }

}