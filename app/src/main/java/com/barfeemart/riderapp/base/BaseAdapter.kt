package com.barfeemart.riderapp.base

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList



abstract class BaseAdapter<B : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<B>>() {
    private val data = mutableListOf<Any>()
    var totalCount: Int = 0

    fun data(): MutableList<Any> {
        return data
    }

    fun <T> addData(data: List<T>) {
        data().addAll(ArrayList<Any>(data))
        Log.d("BaseAdapetrAddData", "" + data.size)

    }

    protected abstract fun viewHolder(@LayoutRes layout: Int, binding: B): BaseViewHolder<B>
    protected abstract fun layout(position: Int): Int

    override fun onCreateViewHolder(parent: ViewGroup, @LayoutRes layout: Int): BaseViewHolder<B> {
        val view = inflateView(parent, layout)
        return viewHolder(layout, view)
    }

    override fun getItemCount(): Int {
        Log.d("BaseAdapetrItemCount", "" + data.size)
        return data().size
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder<B>, position: Int) {
        val data = data()[position]
        try {
            viewHolder.bindData(data, position)
            viewHolder.binding().executePendingBindings()

        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("binviewHolderEx",e.message!!)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return layout(position)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): B {

        return DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            viewType,
            viewGroup,
            false
        )

    }
}