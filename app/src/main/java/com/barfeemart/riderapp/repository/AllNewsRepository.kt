package com.barfeemart.riderapp.repository

import androidx.lifecycle.MutableLiveData
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.data.news.NewsResponse
import kotlinx.coroutines.Job


interface AllNewsRepository {
     fun getAllNews(
        query: Map<String, String>,
        job: Job
    ): MutableLiveData<Result<NewsResponse>>

    fun getDomainSpecificAllNews(
        sortBy: String = "domains=wsj.com", job: Job
    ): MutableLiveData<Result<NewsResponse>>
}