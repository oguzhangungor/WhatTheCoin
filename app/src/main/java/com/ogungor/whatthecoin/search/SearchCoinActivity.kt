package com.ogungor.whatthecoin.search

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.whatthecoin.SearchCoinRecyclerAdapter
import com.ogungor.whatthecoin.R
import com.ogungor.whatthecoin.activity.BaseActivity
import com.ogungor.whatthecoin.databinding.ActivitySeachCoinBinding
import com.ogungor.whatthecoin.network.model.CoinModel
import com.ogungor.whatthecoin.util.extentions.showToastErrorMessage

class SearchCoinActivity : BaseActivity(), SearchCoinActivityContract.View {

    private lateinit var searchCoinActivityPresenter: SearchCoinActivityContract.Presenter

    private lateinit var searchView: SearchView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterSearch: SearchCoinRecyclerAdapter

    override fun getLayout(): Int= R.layout.activity_seach_coin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchCoinActivityPresenter=SearchCoinActivityPresenter().apply {
            setView(this@SearchCoinActivity)
            create()
            getDataFromFireStore()
        }








        /*searchView=findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()
                if (coin.contains(p0)){
                    coinAdapter.filter.filter(p0)
                }
               return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                coinAdapter.filter.filter(p0)

                return false

            }

        })*/

    }

    override fun showToast() {
        showToastErrorMessage()
    }

    override fun initUi() {

        recyclerView=findViewById(R.id.coinListView)
        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        adapterSearch= SearchCoinRecyclerAdapter(ArrayList<CoinModel>())
        recyclerView.adapter=adapterSearch
    }

    override fun showAllCoins(model: ArrayList<CoinModel>) {
        adapterSearch.setList(model)
    }


}