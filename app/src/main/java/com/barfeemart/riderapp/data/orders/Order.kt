package com.barfeemart.riderapp.data.orders

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Order(
    val orderNumber: String,
    val address: String,
    val time: String,
) : Parcelable
