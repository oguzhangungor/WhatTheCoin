package com.ogungor.whatthecoin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.whatthecoin.network.model.CoinModel

class SearchCoinRecyclerAdapter(
    private var coinList: ArrayList<CoinModel>,
) : RecyclerView.Adapter<SearchCoinRecyclerAdapter.BetHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_list_row, parent, false)
        return BetHolder(view)
    }

    override fun onBindViewHolder(holder: BetHolder, position: Int) {
        val currentCoin = coinList[position]

        holder.run {
            currentCoin.coinShortName.let {
                textShortName.text = it
            }
            currentCoin.coinLongName.let {
                textLongName.text = it
            }
        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }


    fun setList(list: ArrayList<CoinModel>) {
        coinList = list
        notifyDataSetChanged()
    }


    inner class BetHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textShortName: TextView = view.findViewById(R.id.short_name)
        var textLongName: TextView = view.findViewById(R.id.long_name)
    }

    interface OnItemClickListener {
        fun onItemClick(model:CoinModel)
    }

}
