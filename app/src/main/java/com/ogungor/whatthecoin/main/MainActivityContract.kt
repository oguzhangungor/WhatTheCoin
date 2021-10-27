package com.ogungor.whatthecoin.main

import com.ogungor.whatthecoin.network.model.NewsModel

interface MainActivityContract {

        interface Presenter {

            fun create ()

            fun setView(view: MainActivityContract.View)

            fun destroy ()

            fun getDataNewsFromFireStore()

        }

        interface View{

            fun initUi()

            fun showAllNews(model : ArrayList<NewsModel>)

            fun showToast()

            fun showList()

            fun searchButtonClick()
        }
}