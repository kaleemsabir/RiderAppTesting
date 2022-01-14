package com.barfeemart.riderapp.repository.implementation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.barfeemart.riderapp.api.AllRiderApi
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.base.BaseRepository
import com.barfeemart.riderapp.data.login.LoginRequest
import com.barfeemart.riderapp.data.login.LoginResponse
import com.barfeemart.riderapp.data.news.NewsResponse
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.repository.LoginRepository
import kotlinx.coroutines.Job


@Suppress("UNCHECKED_CAST")
class LoginRepositoryImpl(private val allRider: AllRiderApi) :
    LoginRepository {

    override fun loginUser(query: Map<String, String>,job: Job): MutableLiveData<Result<LoginResponse>> {
        return object : BaseRepository<LoginResponse, Map<String, String>>() {
            override suspend fun fetchFromNetwork(params: Map<String, String>): LoginResponse {
                return allRider.login(params)
            }
        }.start(query,job) as MutableLiveData<Result<LoginResponse>>
    }


}