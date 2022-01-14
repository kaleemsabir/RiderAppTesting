package com.barfeemart.riderapp.ui.newslisting

import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.base.BaseAdapter
import com.barfeemart.riderapp.base.BaseViewHolder
import com.barfeemart.riderapp.data.news.News
import com.barfeemart.riderapp.databinding.ItemNewsBinding


class NewsAdapter(
    private val clickListener: (result: News) -> Unit
) : BaseAdapter<ItemNewsBinding>() {
    init {
        addData(ArrayList<News>())
    }

    fun addNewsList(data: List<News>) {
        data.let {
            addData(it)
            notifyDataSetChanged()
        }
    }

    override fun viewHolder(
        layout: Int,
        binding: ItemNewsBinding
    ): BaseViewHolder<ItemNewsBinding> {
        return NewsViewHolder(binding, clickListener)
    }

    override fun layout(position: Int): Int {
        return R.layout.item_news
    }

}