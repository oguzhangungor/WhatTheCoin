package com.ogungor.whatthecoin.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ogungor.whatthecoin.main.adapter.ExpandableListViewAdapter
import com.ogungor.whatthecoin.main.adapter.NewsAdapter
import com.ogungor.whatthecoin.R
import com.ogungor.whatthecoin.activity.BaseActivity
import com.ogungor.whatthecoin.details.DetailsActivity
import com.ogungor.whatthecoin.main.listener.NewAdapterClickListener
import com.ogungor.whatthecoin.network.model.CoinModel
import com.ogungor.whatthecoin.newsdetail.NewsDetailsActivity
import com.ogungor.whatthecoin.network.model.NewsModel
import com.ogungor.whatthecoin.util.extentions.launchMainToSearchActivity
import com.ogungor.whatthecoin.util.keys.BundleKeys

class MainActivity : BaseActivity(), MainActivityContract.View {


    private lateinit var mainActivityPresenter: MainActivityContract.Presenter
    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var chapterList: List<String>
    private lateinit var topicList: HashMap<String, List<String>>
    private lateinit var eListView: ExpandableListView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var searchButton: FloatingActionButton





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityPresenter = MainActivityPresenter().apply {
            setView(this@MainActivity)
            create()
            getDataNewsFromFireStore()


        }
    }

    override fun getLayout(): Int=R.layout.activity_main


    override fun initUi() {

        eListView = findViewById(R.id.eListView)
        searchButton = findViewById(R.id.seachActionButton)
        viewPager = findViewById(R.id.viewPager)
        listViewAdapter = ExpandableListViewAdapter(this, chapterList, topicList)
        eListView.setAdapter(listViewAdapter)
    }

    override fun searchButtonClick() {
        searchButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                launchMainToSearchActivity()
            }
        }
        )
    }

    override fun showList() {
        chapterList = ArrayList()
        topicList = HashMap()

        chapterListCreate()
        topicListCreate()

    }

    private fun topicListCreate() {

        val topic1: MutableList<String> = ArrayList()
        topic1.add("Binance Yat??rma")
        topic1.add("Gateio Yat??r??m")
        topic1.add("Metamask Yat??r??m")
        topic1.add("FTX Yat??r??m")
        topic1.add("Paribu Yat??r??m ")
        topic1.add("Bitexxen Yat??r??m")


        val topic2: MutableList<String> = ArrayList()

        topic2.add("Binance ??ekimi")
        topic2.add("Gateio ??ekimi")
        topic2.add("Metamask ??ekimi")
        topic2.add("FTX ??ekimi")
        topic2.add("Paribu ??ekimi")
        topic2.add("Bitexxen ??ekimi")

        val topic3: MutableList<String> = ArrayList()

        topic3.add("NFT ne demek?")
        topic3.add("NFT T??rleri")
        topic3.add("NFT ...")


        val topic4: MutableList<String> = ArrayList()

        topic4.add("ATH ne demek?")
        topic4.add("ATH'nin bir ??nemi var m???")
        topic4.add("ATH'nin BTC ??zerinde ki ??nemi ...")


        val topic5: MutableList<String> = ArrayList()

        topic4.add("FAN TOKEN ne demek?")
        topic4.add("ATH'nin bir ??nemi var m???")
        topic4.add("ATH'nin BTC ??zerinde ki ??nemi ...")

        topicList[chapterList[0]] = topic1
        topicList[chapterList[1]] = topic2
        topicList[chapterList[2]] = topic3
        topicList[chapterList[3]] = topic4
        topicList[chapterList[4]] = topic5
    }

    private fun chapterListCreate() {
        (chapterList as ArrayList<String>).add("Para Yat??rma")
        (chapterList as ArrayList<String>).add("Para ??ekme")
        (chapterList as ArrayList<String>).add("NFT Nedir?")
        (chapterList as ArrayList<String>).add("ATH Nedir?")
        (chapterList as ArrayList<String>).add("FAN TOKEN Nedir?")

    }

    override fun showAllNews(model: ArrayList<NewsModel>) {
        newsAdapter = NewsAdapter(this, model,object : NewAdapterClickListener{
            override fun onNewsClick(model: NewsModel) {
                val intent = Intent(this@MainActivity, NewsDetailsActivity::class.java).apply {
                    putExtra(BundleKeys.KEY_COIN_MODEL,model)
                }
                startActivity(intent)
            }

        })
        viewPager.adapter = newsAdapter
    }

    override fun showToast() {
        Toast.makeText(this, "Hata var", Toast.LENGTH_SHORT).show()
    }


}
