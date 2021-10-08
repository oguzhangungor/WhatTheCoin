package com.ogungor.whatthecoin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.whatthecoin.network.model.CoinModel
import com.squareup.picasso.Picasso

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

        //filterCoin(holder)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }


    fun setList(list: ArrayList<CoinModel>) {
        coinList = list
        notifyDataSetChanged()
    }

    fun filterCoin (holder:BetHolder,coinList: ArrayList<String>){
      /*  var newArrayList:ArrayList<String>
        holder.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                holder.searchView.clearFocus()
                coinList.forEach{
                    if (it.contains(p0.toString())){
                   newArrayList.add(it)
                }
                }

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                coinAdapter.filter.filter(p0)

                return false

            }

        })*/
    }


    inner class BetHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textShortName: TextView = view.findViewById(R.id.short_name)
        var textLongName: TextView = view.findViewById(R.id.long_name)
        var imageCoinLogo: ImageView = view.findViewById(R.id.coinLogo)
        var  searchView:SearchView=view.findViewById(R.id.searchView)
        var recyclerView:RecyclerView=view.findViewById(R.id.coinListView)

    }

    interface OnItemClickListener {
        fun onItemClick(model:CoinModel)
    }



}
