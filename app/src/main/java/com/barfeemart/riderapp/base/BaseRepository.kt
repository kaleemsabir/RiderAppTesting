package com.barfeemart.riderapp.base

import androidx.lifecycle.*
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.data.ErrorDescription
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.http.Body
import retrofit2.http.Field
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class BaseRepository<Response, Params> internal constructor() {

    abstract suspend fun fetchFromNetwork(params: Params): Response


    open fun start(
        params: Params,
        job: Job

    ): LiveData<Result<out Any?>> = liveData(Dispatchers.IO + job) {
        emit(Result.Loading(true))
        try {
            emit(Result.Success(fetchFromNetwork(params)))
        } catch (e: HttpException) {
            emit(Result.NetworkError<Error>(ErrorDescription(e.localizedMessage!!)))

        } catch (e: UnknownHostException) {
            emit(Result.NetworkError<Error>(ErrorDescription(e.localizedMessage!!)))
        } catch (e: SocketTimeoutException) {
            emit(Result.NetworkError<Error>(ErrorDescription(e.localizedMessage!!)))
        } catch (ex: Exception) {
            emit(Result.Failure<Error>(ErrorDescription(ex.localizedMessage!!)))
        }
    }

}