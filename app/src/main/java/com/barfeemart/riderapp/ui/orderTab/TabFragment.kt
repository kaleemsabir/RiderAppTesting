package com.barfeemart.riderapp.ui.orderTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentLoginBinding
import com.barfeemart.riderapp.databinding.FragmentTabLayoutBinding
import com.barfeemart.riderapp.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_tab_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class TabFragment : BaseFragment<FragmentTabLayoutBinding>() {
    private val viewModel by viewModel<TabViewModel>()
    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun initFragment() {
        if (binding.lifecycleOwner == null) {
            binding.apply {
                lifecycleOwner = this@TabFragment
                 viewModel = this@TabFragment.viewModel
            }
        }
        setViewPagerFragments()
    }

    fun setViewPagerFragments() {
        binding.pager.adapter =
            ViewPagerAdapter(requireActivity().supportFragmentManager)
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_tab_layout
    }
}