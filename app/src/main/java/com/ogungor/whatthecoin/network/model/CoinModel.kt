package com.ogungor.whatthecoin.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CoinModel (

        var coinShortName:String?,
        var coinLongName:String?,
        var coinContent1:String?,
        var coinContent2:String?,
        var coinContent3:String?,
        var coinLogoUrl:String?
): Parcelable