package com.barfeemart.riderapp.ui.newslisting

import android.os.Bundle
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseFragment
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.databinding.FragmentNewListBinding
import com.barfeemart.riderapp.ui.newsdetails.NewsDetailsFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
@author Salman Aziz
created on 2/22/21
 **/

class NewsListFragment : BaseFragment<FragmentNewListBinding>() {

    private val viewModel by viewModel<NewsViewModel>()
    private val newsAdapter by lazy {
        NewsAdapter { news ->
            val bundle = Bundle()
            bundle.putParcelable("news", news)
            val args = NewsDetailsFragmentArgs.fromBundle(bundle)
            navigateToDestination(R.id.actionNewsListToDetails, args.toBundle())
        }
    }

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   viewModel.fetchAllNews(1)

    }



    override fun initFragment() {
        if (binding.lifecycleOwner == null) {
            binding.apply {
                lifecycleOwner = this@NewsListFragment
                viewModel = this@NewsListFragment.viewModel
                adapter = newsAdapter
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_new_list






}