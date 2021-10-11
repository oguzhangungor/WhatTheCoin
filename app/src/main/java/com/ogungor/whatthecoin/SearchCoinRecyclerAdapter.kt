package com.ogungor.whatthecoin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.whatthecoin.network.model.CoinModel
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

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
            currentCoin.coinLogoUrl.let {
                Picasso.get().load(currentCoin.coinLogoUrl).into(imageCoinLogo)
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

    fun updateList(model: ArrayList<CoinModel>, searchText:String?) {
        val newList= arrayListOf<CoinModel>()
        val searchText = searchText?.toLowerCase(Locale.getDefault())

        if(searchText!!.isNotEmpty()){
            model.forEach{

                if (it.coinLongName?.toLowerCase(Locale.getDefault())?.contains(searchText)!!){
                    newList.add(it)
                }
            }
            coinList=newList
            notifyDataSetChanged()
        }
        else {
            newList.clear()
            newList.addAll(model)
            coinList=newList
            notifyDataSetChanged()

        }
    }


    inner class BetHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textShortName: TextView = view.findViewById(R.id.short_name)
        var textLongName: TextView = view.findViewById(R.id.long_name)
        var imageCoinLogo: ImageView = view.findViewById(R.id.coinLogo)

    }

    interface OnItemClickListener {
        fun onItemClick(model:CoinModel)
    }



}
