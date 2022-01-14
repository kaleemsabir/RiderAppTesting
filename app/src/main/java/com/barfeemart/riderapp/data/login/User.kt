package com.barfeemart.riderapp.data.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User(
    val id: Int,
    val name: String,
    val phone_number: String,
    val api_token: String,
    val type: String,
    ):Parcelable
