package com.barfeemart.riderapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.barfeemart.riderapp.api.AllRiderApi
import com.barfeemart.riderapp.constants.KEY_PREF_NAME
import com.barfeemart.riderapp.repository.AllNewsRepository
import com.barfeemart.riderapp.repository.LoginRepository
import com.barfeemart.riderapp.repository.implementation.AllNewsRepositoryImpl
import com.barfeemart.riderapp.repository.implementation.LoginRepositoryImpl
import com.barfeemart.riderapp.ui.login.LoginViewModel
import com.barfeemart.riderapp.ui.newslisting.NewsViewModel
import com.barfeemart.riderapp.ui.orderTab.TabViewModel
import com.barfeemart.riderapp.ui.orderdetail.OrderDetailViewModel
import com.barfeemart.riderapp.ui.orderlistingongoing.OrderOnGoingViewModel
import com.barfeemart.riderapp.ui.paymentcollection.PaymentCollectionViewModel
import com.barfeemart.riderapp.ui.paymentcollection.PaymnetCollectionFragment
import com.barfeemart.riderapp.util.EncryptSharedPref
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val repositoryModule = module {
    single { createAllNewsRepository(get()) }
    single { createLoginRepository(get()) }

}


val viewModelModule = module {
    viewModel {
        LoginViewModel(
            get(),
            get()
        )

    }
    viewModel {
        TabViewModel(
            get(),
            get()
        )

    }
    viewModel {
        OrderOnGoingViewModel(
            get(),
            get()
        )
    }
    viewModel {
        OrderDetailViewModel(
            get(),
            get()
        )
    }
    viewModel {
        PaymentCollectionViewModel(
            get(),
            get()
        )
    }
}

val sharedPrefModule = module {
    single { createMasterKey(androidContext()) }
    single { creteEncryptedSharedPref(androidContext(), get()) }
    single { EncryptSharedPref(get()) }
}



fun createAllNewsRepository(allNewsApi: AllRiderApi): AllNewsRepository {
    return AllNewsRepositoryImpl(
        allNewsApi
    )
}
fun createLoginRepository(allRiderApi: AllRiderApi): LoginRepository {
    return LoginRepositoryImpl(
        allRiderApi
    )
}




fun createMasterKey(context: Context): MasterKey {
    return MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()
}

private fun creteEncryptedSharedPref(
    context: Context,
    masterKeyAlias: MasterKey
): SharedPreferences {

    return EncryptedSharedPreferences.create(
        context,
        KEY_PREF_NAME,
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}

