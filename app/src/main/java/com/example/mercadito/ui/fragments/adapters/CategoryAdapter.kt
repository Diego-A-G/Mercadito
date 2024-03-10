package com.example.mercadito.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.vo.CategoryVO

class CategoryAdapter(private val categoryList: MutableList<CategoryVO>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewCategoryName: TextView = itemView.findViewById(R.id.textViewCategoryName)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val btnDelete: ImageView = itemView.findViewById(R.id.buttonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCategory = categoryList[position]
        holder.textViewCategoryName.text = currentCategory.name
        holder.textViewDescription.text = currentCategory.description
        holder.btnDelete.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                categoryList.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }

    override fun getItemCount() = categoryList.size

    fun addItem(item: CategoryVO) {
        categoryList.add(item)
        notifyItemInserted(categoryList.size - 1)
    }
}
