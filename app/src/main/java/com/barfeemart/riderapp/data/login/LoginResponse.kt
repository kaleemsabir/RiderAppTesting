package com.barfeemart.riderapp.data.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/**
@author Salman Aziz
created on 2/22/21
 **/

@Parcelize
data class LoginResponse(val status: String, val data: User):
    Parcelable