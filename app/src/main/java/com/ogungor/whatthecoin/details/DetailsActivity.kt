package com.ogungor.whatthecoin.details

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ogungor.whatthecoin.R
import com.ogungor.whatthecoin.activity.BaseActivity
import com.ogungor.whatthecoin.util.extentions.showToastErrorMessage
import com.squareup.picasso.Picasso

class DetailsActivity : BaseActivity(), DetailsActivityContract.View {
    private lateinit var detailsActivityPresenter: DetailsActivityContract.Presenter
    private lateinit var coinLogoImageView: ImageView
    private lateinit var coinTitleTextView: TextView
    private lateinit var coinContentTextView: TextView
    private lateinit var coinContentSecondTextView: TextView
    private lateinit var coinContentThirtTextView: TextView
    private lateinit var coinContentFourTextView: TextView
    private lateinit var coinContentFiveTextView: TextView
    private lateinit var coinContentSixTextView: TextView




    override fun getLayout(): Int = R.layout.details_activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        detailsActivityPresenter = DetailsActivityPresenter().apply {
            setView(this@DetailsActivity)
            create(intent)
        }
    }



    override fun bindViews() {

        coinLogoImageView = findViewById(R.id.details_coin_logo)
        coinTitleTextView = findViewById(R.id.details_coin_name)
        coinContentTextView = findViewById(R.id.content_first)
        coinContentSecondTextView = findViewById(R.id.content_second)
        coinContentThirtTextView = findViewById(R.id.content_thirt)
        coinContentFourTextView = findViewById(R.id.content_four)
        coinContentFiveTextView = findViewById(R.id.content_five)
        coinContentSixTextView = findViewById(R.id.content_six)

    }


    override fun showToast() {
        showToastErrorMessage()
    }

    override fun setCoinName(coinLongName: String?) {
        coinTitleTextView.text = coinLongName?: ""
    }

    override fun setCoinLogo(coinCoinLogo: String?) {
        Picasso.get().load(coinCoinLogo).into(coinLogoImageView)
    }

    override fun setCoinContent(coinContent: String?) {
        coinContentTextView.text=coinContent?: ""
        coinContentSecondTextView.text=coinContent?:""
        coinContentThirtTextView.text=coinContent?: ""
        coinContentFourTextView.text=coinContent?: ""
        coinContentFiveTextView.text=coinContent?: ""
        coinContentSixTextView.text=coinContent?: ""

    }

}


