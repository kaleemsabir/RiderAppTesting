package com.barfeemart.riderapp.repository.implementation

import androidx.lifecycle.MutableLiveData
import com.barfeemart.riderapp.api.AllRiderApi
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.base.BaseRepository
 import com.barfeemart.riderapp.data.news.NewsResponse
import com.barfeemart.riderapp.repository.AllNewsRepository
import kotlinx.coroutines.Job


@Suppress("UNCHECKED_CAST")
class AllNewsRepositoryImpl(private val allNewsApi: AllRiderApi) :
    AllNewsRepository {

    override fun getAllNews(
        query: Map<String, String>,
        job: Job
    ): MutableLiveData<Result<NewsResponse>> {
        return object : BaseRepository<NewsResponse, Map<String, String>>() {
            override suspend fun fetchFromNetwork(params: Map<String, String>): NewsResponse {
                return allNewsApi.getAllNews(params)
            }
         }.start(query, job) as MutableLiveData<Result<NewsResponse>>
    }


    override fun getDomainSpecificAllNews(
        sortBy: String,
        job: Job
    ): MutableLiveData<Result<NewsResponse>> {
        return object : BaseRepository<NewsResponse, String>() {
            override suspend fun fetchFromNetwork(params: String): NewsResponse {
                return allNewsApi.getDomainSpecificAllNews(params)
            }

         }.start(sortBy, job) as MutableLiveData<Result<NewsResponse>>
    }

}