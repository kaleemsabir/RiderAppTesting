package com.barfeemart.riderapp.ui.paymentcollection

import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentPaymnetCollectionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PaymnetCollectionFragment : BaseFragment<FragmentPaymnetCollectionBinding>() {
    private val viewModel by viewModel<PaymentCollectionViewModel>()

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun initFragment() {
        if (binding.lifecycleOwner == null) {
            binding.apply {
                lifecycleOwner = this@PaymnetCollectionFragment
                viewModel = this@PaymnetCollectionFragment.viewModel

            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_paymnet_collection
    }

}