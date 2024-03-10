package com.example.mercadito.ui.managers

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mercadito.database.AppDatabase
import com.example.mercadito.repositories.IItemRepo
import com.example.mercadito.repositories.ItemRepository

class CategoryViewModelFactory(
    private val itemRepository: IItemRepo
): ViewModelProvider.Factory {

    constructor(context: Context):this(
        ItemRepository(
            AppDatabase.getDatabase(context)
        )
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(itemRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}