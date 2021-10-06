package com.ogungor.whatthecoin.search

import com.ogungor.whatthecoin.network.model.CoinModel

interface SearchCoinActivityContract {

    interface Presenter {

        fun create ()

        fun setView(view: SearchCoinActivityContract.View)

        fun destroy ()

        fun getDataFromFireStore()

    }

    interface View{
        fun initUi()

        fun showAllCoins(model : ArrayList<CoinModel>)

        fun showToast()

    }

}