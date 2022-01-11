package com.barfeemart.riderapp.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.base.BaseAdapter
import com.barfeemart.riderapp.data.news.NewsResponse
import com.barfeemart.riderapp.ui.newslisting.NewsAdapter
import com.barfeemart.riderapp.ui.newslisting.NewsViewModel
import com.barfeemart.riderapp.util.Paginator

/**
@author Salman Aziz
created on 2/22/21
 **/

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: BaseAdapter<*>) {
    recyclerView.adapter = recyclerView.adapter ?: adapter

}

@BindingAdapter("newsPagination")
fun bindNewPagination(recyclerView: RecyclerView, newsViewModel: NewsViewModel) {
    Paginator(
        recyclerView,
        isLoading = {
            return@Paginator newsViewModel.outcomeLiveData.value is Result.Loading
        },
        loadMore = { newsViewModel.fetchAllNews(it) }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("payload")
fun bindRecyclerData(recyclerView: RecyclerView, response: Result<NewsResponse>?) {
    response?.let {
        if (it is Result.Success) {
            it.data.let { newsResponse ->
                val adapter = recyclerView.adapter as? NewsAdapter
                adapter?.totalCount = newsResponse.totalResults
                adapter?.addNewsList(newsResponse.articles)
            }
        }
    }

}