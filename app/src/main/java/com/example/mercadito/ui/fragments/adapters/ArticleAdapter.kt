package com.example.mercadito.ui.fragments.adapters

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.vo.ItemVO

class ArticleAdapter(
    private var productList: MutableList<ItemVO>,
    private val clearAdapter: IClearAdapter?
) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val editTextViewName: EditText = itemView.findViewById(R.id.editTextName)
        val editTextViewPrice: TextView = itemView.findViewById(R.id.editTextPrice)
        val editTextViewDescription: TextView = itemView.findViewById(R.id.editTextDescription)
        val editTextViewQuantity: TextView = itemView.findViewById(R.id.editTextQuantity)
        val buttonAdd: ImageView = itemView.findViewById(R.id.buttonAdd)
        val buttonDelete: ImageView = itemView.findViewById(R.id.buttonDelete)
        val buttonMinus: ImageView = itemView.findViewById(R.id.buttonSubtract)
        val buttonEdit: ImageView = itemView.findViewById(R.id.buttonEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]

        holder.editTextViewName.isEnabled = true
        holder.editTextViewName.text = Editable.Factory.getInstance().newEditable(currentItem.name)
        holder.editTextViewPrice.text = "Price: $${currentItem.cost}"
        holder.editTextViewDescription.text = currentItem.description
        holder.editTextViewQuantity.text = "Quantity: ${currentItem.amount}"

        holder.buttonAdd.setOnClickListener {
            currentItem.amount++
            holder.editTextViewQuantity.text = "Quantity: ${currentItem.amount}"
        }

        holder.buttonDelete.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                productList.removeAt(pos)
                if (productList.size == 0) clearAdapter?.onCleanAdapter()
                notifyItemRemoved(pos)
            }

        }

        holder.buttonMinus.setOnClickListener {
            if (currentItem.amount > 0) {
                currentItem.amount--
                holder.editTextViewQuantity.text = "Quantity: ${currentItem.amount}"
            }
        }

        holder.buttonEdit.setOnClickListener {
            val enabled = !holder.editTextViewName.isEnabled
            holder.editTextViewName.isEnabled = enabled
            holder.editTextViewPrice.isEnabled = enabled
            holder.editTextViewDescription.isEnabled = enabled
            holder.editTextViewQuantity.isEnabled = enabled
        }
        if (clearAdapter == null){
            holder.buttonAdd.visibility =View.GONE
            holder.buttonDelete.visibility =View.GONE
            holder.buttonMinus.visibility =View.GONE
            holder.buttonEdit.visibility =View.GONE
        }
    }


    override fun getItemCount() = productList.size

    fun addItem(item: ItemVO) {
        productList.add(item)
        notifyItemInserted(productList.size - 1)
    }

    fun removeItem(position: Int) {
        if (position in productList.indices) {
            productList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeAll() {
        productList = mutableListOf()
        notifyDataSetChanged()
    }

}

