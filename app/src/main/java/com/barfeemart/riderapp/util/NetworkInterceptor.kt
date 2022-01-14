package com.barfeemart.riderapp.util

import com.barfeemart.riderapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class NetworkInterceptor : Interceptor {
     override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .build()
        val request: Request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}