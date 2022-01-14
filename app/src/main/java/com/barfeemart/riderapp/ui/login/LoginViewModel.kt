package com.barfeemart.riderapp.ui.login

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.barfeemart.riderapp.R
import com.barfeemart.riderapp.api.Result
import com.barfeemart.riderapp.base.BaseViewModel
import com.barfeemart.riderapp.constants.pageSize
import com.barfeemart.riderapp.data.login.LoginResponse
import com.barfeemart.riderapp.data.news.NewsResponse
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.repository.LoginRepository
import com.barfeemart.riderapp.util.EncryptSharedPref


class LoginViewModel(
    private val loginRepository: LoginRepository,
    private val sharedPreferences: EncryptSharedPref

) : BaseViewModel() {
      var _loginLiveData: MutableLiveData<Result<LoginResponse>> = MutableLiveData()

     var loginResultLiveData: MediatorLiveData<Result<LoginResponse>> = MediatorLiveData()

    fun navigateToHome(view: View) {
        Navigation.findNavController(view).navigate(R.id.actionOrderListing)
    }
    fun getLogin() = loginResultLiveData

    fun login() {
        val data: MutableMap<String, String> = HashMap()
        data["phone_number"] = "3087446697"
        data["password"] = "123123"
        _loginLiveData = loginRepository.loginUser(data,job)
        loginResultLiveData.addSource(_loginLiveData) { outcome ->
            run {
                outcomeLiveData.value = outcome
                Log.d("LoginViewModel", "" + outcome)
                outcome.let {
                    loginResultLiveData.value = it
                }
                when (outcome) {
                    is Result.Success -> {
                        outcome.let {
                            loginResultLiveData.value = it
                        }
                    }
                    else -> {

                    }
                }

            }
        }

    }
}