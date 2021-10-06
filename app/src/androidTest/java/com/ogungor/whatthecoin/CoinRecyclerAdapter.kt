package com.ogungor.whatthecoin

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.whatthecoin.network.model.CoinModel

class CoinRecyclerAdapter (private var coinList:ArrayList<CoinModel>, private var listener: AdapterView.OnItemClickListener):RecyclerView.Adapter<SearchCoinRecyclerAdapter.BetHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BetHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }








    inner class BetHolder (view: View): RecyclerView.ViewHolder(view){
        var textShortName:TextView=view.findViewById(R.id.short_name)
        var textLongName:TextView=view.findViewById(R.id.long_name)
    }

}
