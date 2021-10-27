package com.ogungor.whatthecoin.details

import android.content.Intent
import com.ogungor.whatthecoin.network.model.CoinModel

interface DetailsActivityContract {

    interface Presenter {

        fun setView(view:DetailsActivityContract.View)

        fun create(intent: Intent)

        fun destroy()


    }

    interface View {

        fun bindViews()


        fun showToast()


        fun setCoinName(coinShortName: String?)

        fun setCoinLogo(coinShortName: String?)

        fun setCoinContent(coinShortName: String?)
    }

}