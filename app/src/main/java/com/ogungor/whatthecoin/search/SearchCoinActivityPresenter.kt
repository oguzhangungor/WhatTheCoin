package com.ogungor.whatthecoin.search

import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.ogungor.whatthecoin.network.ApiResponseListener
import com.ogungor.whatthecoin.network.NetworkService
import com.ogungor.whatthecoin.network.model.CoinModel
import com.ogungor.whatthecoin.util.repo.FirebaseApi

class SearchCoinActivityPresenter : SearchCoinActivityContract.Presenter{

    private var view: SearchCoinActivityContract.View?=null
    private var networkService: NetworkService?=null

    override fun create() {
        networkService= FirebaseApi()
        view?.apply {
            initUi() }
    }

    override fun setView(view: SearchCoinActivityContract.View) {
        this.view=view
    }

    override fun destroy() {

    }

    override fun getDataFromFireStore() {
       networkService?.getDashboardList(object : ApiResponseListener<ArrayList<CoinModel>>
       {
           override fun onSuccess(model: ArrayList<CoinModel>) {
              if (model.isNotEmpty()){
                  view?.run {
                      showAllCoins(model)
                  }
              }
           }

           override fun onFail() {
               view?.showToast()
           }
       },"CoinList")
    }


    fun filterRecyclerView(){}
}