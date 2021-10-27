package com.ogungor.whatthecoin.main.listener

import com.ogungor.whatthecoin.network.model.NewsModel

interface NewAdapterClickListener {
    fun onNewsClick(model: NewsModel)
}