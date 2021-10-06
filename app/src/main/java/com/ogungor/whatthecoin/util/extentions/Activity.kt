package com.ogungor.whatthecoin.util.extentions

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.ogungor.whatthecoin.search.SearchCoinActivity

fun Activity.launchMainToSearchActivity(){
    this.startActivity(Intent(this, SearchCoinActivity::class.java))
}

fun Activity.showToastErrorMessage(){
    Toast.makeText(this,"Hata mesajı",Toast.LENGTH_SHORT).show()
}