package com.ogungor.whatthecoin.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.ogungor.whatthecoin.R
import com.ogungor.whatthecoin.main.MainActivity
import com.ogungor.whatthecoin.main.listener.NewAdapterClickListener
import com.ogungor.whatthecoin.network.model.NewsModel
import com.squareup.picasso.Picasso


class NewsAdapter(
    private val context: Context,
    private val myNewsArrayList: ArrayList<NewsModel>,
    private val listener: NewAdapterClickListener
) : PagerAdapter() {
    override fun getCount(): Int {
        return myNewsArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.news_item, container, false)

        val news_image = view.findViewById<View>(R.id.news_banner) as ImageView
        val news_title = view.findViewById<View>(R.id.news_title) as TextView

        Picasso.get().load(myNewsArrayList[position].newsImage).into(news_image)
        news_title.text = myNewsArrayList[position].newsTitle

        view.setOnClickListener {
            when (position) {
                0, 1, 2 -> {
                    listener.onNewsClick(myNewsArrayList[position])
                }
            }
        }
        container.addView(view)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}