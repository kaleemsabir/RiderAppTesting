package com.barfeemart.riderapp

import android.app.Application
import com.barfeemart.riderapp.di.networkModule
import com.barfeemart.riderapp.di.repositoryModule
import com.barfeemart.riderapp.di.sharedPrefModule
import com.barfeemart.riderapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
/**
@author Salman Aziz
created on 2/22/21
 **/

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                networkModule + repositoryModule + viewModelModule + sharedPrefModule
            )
        }

    }
}