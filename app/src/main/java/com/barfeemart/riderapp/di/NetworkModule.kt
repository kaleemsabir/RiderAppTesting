package com.barfeemart.riderapp.di

import com.barfeemart.riderapp.BuildConfig
import com.barfeemart.riderapp.api.AllRiderApi
import com.barfeemart.riderapp.constants.connectionTimeOut
import com.barfeemart.riderapp.constants.readTimeOut
import com.barfeemart.riderapp.util.NetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(get(), BuildConfig.BASE_URL) }
    single { createAllRiderApi(get()) }
 }

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }
    return OkHttpClient.Builder()
        .connectTimeout(connectionTimeOut, TimeUnit.SECONDS)
        .readTimeout(readTimeOut, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(NetworkInterceptor())

        .build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun createAllRiderApi(retrofit: Retrofit): AllRiderApi = retrofit.create(AllRiderApi::class.java)
