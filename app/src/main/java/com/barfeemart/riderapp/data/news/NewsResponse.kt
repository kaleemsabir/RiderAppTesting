package com.barfeemart.riderapp.data.news

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/**
@author Salman Aziz
created on 2/22/21
 **/

@Parcelize
data class NewsResponse(val status: String, val totalResults: Int, val articles: List<News>):
    Parcelable