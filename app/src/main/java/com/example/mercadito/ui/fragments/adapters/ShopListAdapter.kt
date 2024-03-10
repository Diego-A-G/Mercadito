package com.example.mercadito.ui.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.vo.ShopListVO

class ShopListAdapter(
    private val context: Context,
    private val productList: List<ShopListVO>
) : RecyclerView.Adapter<ShopListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textViewTitle)
        val recyclerViewProducts: RecyclerView = itemView.findViewById(R.id.recyclerViewProducts)
        val textViewTotal: TextView = itemView.findViewById(R.id.textViewTotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerView = holder.recyclerViewProducts
        val dataList = productList[position].items
        val adapter = ArticleAdapter(dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        // Calcula el total de la orden

        var total = 0.0
        for (product in productList[position].items) {
            total += product.cost
        }
        holder.title.text = productList[position].name
        holder.textViewTotal.text = "Total: $total"
    }

    override fun getItemCount() = 1
}
