package com.ogungor.whatthecoin.details

import android.content.Intent
import com.ogungor.whatthecoin.network.ApiResponseListener
import com.ogungor.whatthecoin.network.NetworkService
import com.ogungor.whatthecoin.network.model.CoinModel
import com.ogungor.whatthecoin.util.keys.BundleKeys
import com.ogungor.whatthecoin.util.repo.FirebaseApi

class DetailsActivityPresenter : DetailsActivityContract.Presenter{

    private var view:DetailsActivityContract.View?=null
    private var networkService: NetworkService?=null
    private var coinModel: CoinModel?=null

    override fun setView(view: DetailsActivityContract.View) {
        this.view=view
    }

    override fun create(intent: Intent) {
        networkService=FirebaseApi()
        initIntentValues(intent)
        initUi()
    }

    private fun initUi() {
        view?.run {
            bindViews()
            coinModel?.let { model ->
                setCoinName(model.coinLongName)
                setCoinLogo(model.coinLogoUrl)
                setCoinContent(model.coinContent1)
            }
        }
    }

    private fun initIntentValues(intent: Intent) {
        this.coinModel = intent.getParcelableExtra(BundleKeys.KEY_COIN_MODEL) as? CoinModel
    }

    override fun destroy() {
       this.view=null
    }

}