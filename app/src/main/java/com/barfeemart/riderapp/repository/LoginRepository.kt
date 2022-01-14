package com.barfeemart.riderapp.repository

import androidx.lifecycle.MutableLiveData
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.data.login.LoginResponse
import com.barfeemart.riderapp.data.news.NewsResponse
import kotlinx.coroutines.Job


interface LoginRepository {
     fun loginUser(
         query: Map<String, String>,
         job: Job
    ): MutableLiveData<Result<LoginResponse>>


}