package com.ogungor.whatthecoin.newsdetail

import android.content.Intent

interface NewsDetailsActivityContact {

    interface Presenter{

        fun setView(view:NewsDetailsActivity)

        fun destroy()

        fun create(intent: Intent)

    }


    interface View{

        fun initUi()

        fun bindViews()

        fun setNewsImage(newsImage: String?)

        fun setNewsTitle(newsTitle: String?)

        fun setNewsContent(newsContent:String?)

        fun setNewsContentSec(newsContentSec: String?)
    }
}