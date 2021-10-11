package com.ogungor.whatthecoin.search

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.whatthecoin.SearchCoinRecyclerAdapter
import com.ogungor.whatthecoin.R
import com.ogungor.whatthecoin.activity.BaseActivity
import com.ogungor.whatthecoin.network.model.CoinModel
import com.ogungor.whatthecoin.util.extentions.showToastErrorMessage
import java.util.*
import java.util.Locale.getDefault
import kotlin.collections.ArrayList

class SearchCoinActivity : BaseActivity(), SearchCoinActivityContract.View {

    private lateinit var searchCoinActivityPresenter: SearchCoinActivityContract.Presenter
    var newList = arrayListOf<CoinModel>()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterSearch: SearchCoinRecyclerAdapter
    private lateinit var searchView: SearchView

    override fun getLayout(): Int = R.layout.activity_seach_coin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchCoinActivityPresenter = SearchCoinActivityPresenter().apply {
            setView(this@SearchCoinActivity)
            create()
            getDataFromFireStore()
        }


    }

    override fun showToast() {
        showToastErrorMessage()
    }


    override fun initUi() {
        searchView = findViewById(R.id.searchViewCoin)
        recyclerView = findViewById(R.id.coinListView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapterSearch = SearchCoinRecyclerAdapter(ArrayList<CoinModel>())
        recyclerView.adapter = adapterSearch


    }

    override fun showAllCoins(model: ArrayList<CoinModel>) {
        adapterSearch.setList(model)
    }


    override fun filterSearchCoin(model: ArrayList<CoinModel>) {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                adapterSearch.updateList(model, p0)

                return false
            }
        })


    }


}