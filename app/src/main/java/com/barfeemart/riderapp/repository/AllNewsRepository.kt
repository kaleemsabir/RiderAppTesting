package com.barfeemart.riderapp.repository

import androidx.lifecycle.MutableLiveData
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.data.news.NewsResponse
import kotlinx.coroutines.Job
/**
@author Salman Aziz
created on 2/22/21
 **/

interface AllNewsRepository {
     fun getAllNews(
        query: Map<String, String>,
        job: Job
    ): MutableLiveData<Result<NewsResponse>>

    fun getDomainSpecificAllNews(
        sortBy: String = "domains=wsj.com", job: Job
    ): MutableLiveData<Result<NewsResponse>>
}