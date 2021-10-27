package com.ogungor.whatthecoin.util.repo

import com.google.firebase.firestore.FirebaseFirestore
import com.ogungor.whatthecoin.network.model.NewsModel
import com.ogungor.whatthecoin.network.ApiResponseListener
import com.ogungor.whatthecoin.network.NetworkService
import com.ogungor.whatthecoin.network.model.CoinModel

class FirebaseApi : NetworkService {

    companion object {
        const val COIN_SHORT_NAME = "short_name"
        const val COIN_LONG_NAME = "full_name"
        const val COIN_CONTENT_FIRST = "content"
        const val COIN_CONTENT_SECOND = "content"
        const val COIN_CONTENT_THIRT = "content"
        const val COIN_LOGO_URL = "logo_url"
        const val NEWS_TITLE = "news_title"
        const val NEWS_BANNER = "banner_url"
        const val NEWS_CONTENT = "news_content"
        const val NEWS_CONTENT_SEC = "news_content_sec"
    }

    private val firebaseDB: FirebaseFirestore = FirebaseFirestore.getInstance()


    override fun getDashboardList(
        apiResponseListener: ApiResponseListener<ArrayList<CoinModel>>,
        tableName: String
    ) {
        val FirebaseApiTable = tableName

        firebaseDB.collection(FirebaseApiTable).addSnapshotListener { snaphot, exception ->

            if (exception != null) {
                apiResponseListener.onFail()
            } else {
                snaphot?.documents?.let {
                    val coinList = ArrayList<CoinModel>()
                    for (document in it) {
                        coinList.add(
                            CoinModel(
                                coinShortName = document.getString(COIN_SHORT_NAME),
                                coinLongName = document.getString(COIN_LONG_NAME),
                                coinContent1 = document.getString(COIN_CONTENT_FIRST),
                                coinLogoUrl = document.getString(COIN_LOGO_URL),
                                coinContent2 = document.getString(COIN_CONTENT_FIRST),
                                coinContent3 = document.getString(COIN_CONTENT_FIRST)


                                )
                        )
                    }

                    apiResponseListener.onSuccess(coinList)
                } ?: apiResponseListener.onFail()
            }


        }
    }

    override fun getDashNewsboardList(
        apiResponseListener: ApiResponseListener<ArrayList<NewsModel>>,
        tableName: String
    ) {
        val FirebaseApiTable = tableName
        firebaseDB.collection(FirebaseApiTable).addSnapshotListener { snaphot, exception ->
            if (exception != null) {
                apiResponseListener.onFail()
            } else {
                snaphot?.documents?.let {


                    var newsList = ArrayList<NewsModel>()
                    for (document in it) {
                        newsList.add(
                            NewsModel(
                                newsImage = document.getString(NEWS_BANNER),
                                newsTitle = document.getString(NEWS_TITLE),
                                newsContent =document.getString(NEWS_CONTENT),
                                newsContentSec =document.getString(NEWS_CONTENT_SEC)
                            )
                        )
                    }

                    apiResponseListener.onSuccess(newsList)

                }?:apiResponseListener.onFail()


            }


        }
    }
}
