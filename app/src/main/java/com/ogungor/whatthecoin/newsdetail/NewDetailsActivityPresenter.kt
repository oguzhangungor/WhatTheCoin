package com.ogungor.whatthecoin.newsdetail

import android.content.Intent
import com.ogungor.whatthecoin.network.NetworkService
import com.ogungor.whatthecoin.network.model.NewsModel
import com.ogungor.whatthecoin.util.keys.BundleKeys
import com.ogungor.whatthecoin.util.repo.FirebaseApi

class NewDetailsActivityPresenter : NewsDetailsActivityContact.Presenter {
        private var view:NewsDetailsActivityContact.View?=null
    private var networkService: NetworkService?=null
    private  var newsModel: NewsModel?=null



    override fun create(intent: Intent) {
        networkService=FirebaseApi()
       initIntentValues(intent)
        initUi()
    }

    private fun initUi(){
        view?.run {
            bindViews()
            newsModel?.let {model->
                setNewsImage(model.newsImage)
                setNewsTitle(model.newsTitle)
                setNewsContent(model.newsContent)
                setNewsContentSec(model.newsContentSec)



            }

        }

    }

    private fun initIntentValues(intent: Intent) {
        this.newsModel=intent.getParcelableExtra(BundleKeys.KEY_COIN_MODEL) as? NewsModel
    }

    override fun setView(view:NewsDetailsActivity) {
       this.view=view
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
}