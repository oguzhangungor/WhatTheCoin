package com.ogungor.whatthecoin.main

import com.ogungor.whatthecoin.network.ApiResponseListener
import com.ogungor.whatthecoin.network.NetworkService
import com.ogungor.whatthecoin.network.model.NewsModel
import com.ogungor.whatthecoin.util.repo.FirebaseApi

class MainActivityPresenter : MainActivityContract.Presenter {
    private var view: MainActivityContract.View? = null
    private var networkService: NetworkService? = null

    override fun create() {
        networkService = FirebaseApi()
        view?.apply {
            showList()
            initUi()
            searchButtonClick()
        }

    }

    override fun setView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun destroy() {
        this.view=null
    }

    override fun getDataNewsFromFireStore() {
        networkService?.getDashNewsboardList(object : ApiResponseListener<ArrayList<NewsModel>> {
            override fun onSuccess(model: ArrayList<NewsModel>) {
                if (model.isNotEmpty()) {
                    view?.apply {
                        showAllNews(model)
                    }
                }
            }

            override fun onFail() {
                view?.showToast()
            }
        }, "NewsList")
    }
}