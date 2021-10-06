package com.ogungor.whatthecoin.util.repo

import com.google.firebase.firestore.FirebaseFirestore
import com.ogungor.whatthecoin.network.ApiResponseListener
import com.ogungor.whatthecoin.network.NetworkService
import com.ogungor.whatthecoin.network.model.CoinModel

class FirebaseApi :NetworkService {

    companion object{
        const val COIN_SHORT_NAME="short_name"
        const val COIN_LONG_NAME="long_name"
        const val COIN_CONTENT ="content"
    }

    private val firebaseDB:FirebaseFirestore= FirebaseFirestore.getInstance()


    override fun getDashboardList(
        apiResponseListener: ApiResponseListener<ArrayList<CoinModel>>,
        tableName: String
    ) {
        val FirebaseApiTable=tableName
        firebaseDB.collection(FirebaseApiTable).addSnapshotListener { snaphot, exception ->

            if (exception!=null)
            {
                apiResponseListener.onFail()
            }
            else {
                snaphot?.documents?.let {
                    val coinList=ArrayList<CoinModel>()
                    for (document in it )
                    {
                        coinList.add(
                            CoinModel(
                                coinShortName = document.getString(COIN_SHORT_NAME),
                                coinLongName = document.getString(COIN_LONG_NAME),
                                coinContent = document.getString(COIN_CONTENT)
                            )
                        )
                    }

                    apiResponseListener.onSuccess(coinList)
                }?: apiResponseListener.onFail()
            }



        }
    }

}