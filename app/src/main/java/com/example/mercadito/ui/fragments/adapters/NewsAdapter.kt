package com.example.mercadito.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.vo.NewsVO

class NewsAdapter(
    private val dataList: List<NewsVO>,
    private val itemClickListener: IItemTouched
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val description: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.title.text = currentItem.title
        val resourceId = holder.itemView.context.resources.getIdentifier(currentItem.images, "drawable", holder.itemView.context.packageName)

        if (resourceId != 0) holder.imageView.setImageResource(resourceId)
        else holder.imageView.setImageResource(R.drawable.shopping_bag)

        holder.description.text = currentItem.description
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(currentItem)
        }
    }


    override fun getItemCount() = dataList.size
}
