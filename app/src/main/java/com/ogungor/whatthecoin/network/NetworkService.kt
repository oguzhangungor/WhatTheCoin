package com.ogungor.whatthecoin.network

import com.ogungor.whatthecoin.network.model.CoinModel

interface NetworkService {

    fun getDashboardList(apiResponseListener: ApiResponseListener<ArrayList<CoinModel>>, tableName:String)
}