package com.ogungor.whatthecoin.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CoinModel (

        var coinShortName:String?,
        var coinLongName:String?,
        var coinContent:String?,
        var coinLogoUrl:String?
): Parcelable