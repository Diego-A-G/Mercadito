package com.example.mercadito.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.vo.ItemVO

class ArticleAdapter(private val productList: List<ItemVO>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val textViewQuantity: TextView = itemView.findViewById(R.id.textViewQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.textViewName.text = currentItem.name
        holder.textViewPrice.text = "Price: $${currentItem.cost}"
        holder.textViewDescription.text = currentItem.description
        holder.textViewQuantity.text = "Quantity: ${currentItem.amount}"
    }

    override fun getItemCount() = productList.size
}

