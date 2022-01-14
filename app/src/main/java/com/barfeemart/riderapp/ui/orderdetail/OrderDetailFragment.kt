package com.barfeemart.riderapp.ui.orderdetail


import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentOrderDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrderDetailFragment : BaseFragment<FragmentOrderDetailBinding>() {
    private val viewModel by viewModel<OrderDetailViewModel>()

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun initFragment() {
       if(binding.lifecycleOwner == null){
           binding.apply {
               lifecycleOwner = this@OrderDetailFragment
               viewModel = this@OrderDetailFragment.viewModel
           }
       }
    }

    override fun getLayoutId(): Int {
      return R.layout.fragment_order_detail
    }

}