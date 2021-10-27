package com.ogungor.whatthecoin.newsdetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ogungor.whatthecoin.R
import com.ogungor.whatthecoin.activity.BaseActivity
import com.squareup.picasso.Picasso

class NewsDetailsActivity :BaseActivity(),NewsDetailsActivityContact.View
{
    private lateinit var newDetailsActivityPresenter:NewsDetailsActivityContact.Presenter
    private lateinit var newsBannerImageView: ImageView
    private lateinit var newsTitleTextView: TextView
    private lateinit var newsContentTextView:TextView
    private lateinit var newsContentSecTextView:TextView


    override fun getLayout(): Int=R.layout.news_details_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newDetailsActivityPresenter=NewDetailsActivityPresenter().apply {
            setView(this@NewsDetailsActivity)
            create(intent)

        }
    }



    override fun bindViews(){

        newsBannerImageView=findViewById(R.id.newsBannerDetails)
        newsTitleTextView=findViewById(R.id.newsTitleDetails)
        newsContentTextView=findViewById(R.id.newsContentDetails)
        newsContentSecTextView=findViewById(R.id.newsContentSecDetails)


    }

    override fun setNewsImage(newsImage: String?) {
        Picasso.get().load(newsImage).into(newsBannerImageView)
    }
    override fun setNewsTitle(newsTitle: String?) {
        newsTitleTextView.text=newsTitle?:""
    }
    override fun setNewsContent(newsContent:String?) {
      newsContentTextView.text=newsContent?:""
    }
    override fun setNewsContentSec(newsContentSec:String?) {
       newsContentSecTextView.text=newsContentSec?:""
    }

    override fun initUi() {



    }

}
