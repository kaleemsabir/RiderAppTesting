package com.barfeemart.riderapp.data.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersResponse(val status: String, val data: List<User>):
    Parcelable