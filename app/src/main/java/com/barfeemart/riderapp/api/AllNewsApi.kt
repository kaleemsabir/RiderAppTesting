package com.barfeemart.riderapp.api

import com.barfeemart.riderapp.data.login.LoginRequest
import com.barfeemart.riderapp.data.login.LoginResponse
import com.barfeemart.riderapp.data.login.User
import com.barfeemart.riderapp.data.news.NewsResponse
import retrofit2.http.*

/**
@author Salman Aziz
created on 2/22/21
 **/

interface AllRiderApi {
    @GET("/v2/everything")
    suspend fun getAllNews(
        @QueryMap options: Map<String, String>
    ): NewsResponse

    @GET("/v2/everything")
    suspend fun getDomainSpecificAllNews(
        @Query("sortBy") sortBy: String = "domains=wsj.com"
    ): NewsResponse

    @POST("/v1/rider/login")
    suspend fun login(@Body login: Map<String, String>)
    :LoginResponse


}
// http://newsapi.org/v2/everything?q=tesla&from=2021-01-03&sortBy=publishedAt&apiKey=API_KEY
//http://newsapi.org/v2/everything?domains=wsj.com&apiKey=API_KEY