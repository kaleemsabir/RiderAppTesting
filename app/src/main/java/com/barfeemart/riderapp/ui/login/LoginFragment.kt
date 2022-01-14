package com.barfeemart.riderapp.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentLoginBinding
import com.barfeemart.riderapp.ui.newslisting.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment :  BaseFragment<FragmentLoginBinding>() {
    // TODO: Rename and change types of parameters
    private val viewModel by viewModel<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     }

    override fun getLayoutId(): Int {
       return R.layout.fragment_login
    }


    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun initFragment() {
        if (binding.lifecycleOwner == null) {
            binding.apply {
                lifecycleOwner = this@LoginFragment
                viewModel = this@LoginFragment.viewModel
            }
        }
        viewModel._loginLiveData.observe(this, Observer{
            response->
            Log.d("kjlk;lkl","Reached Observe ");

        })
    }
}