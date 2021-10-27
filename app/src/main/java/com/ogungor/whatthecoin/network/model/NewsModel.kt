package com.ogungor.whatthecoin.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NewsModel (

        var newsImage: String?,
        var newsTitle:String?,
        var newsContent:String?,
        var newsContentSec:String?

        ):Parcelable