package com.example.mercadito.ui.managers

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mercadito.database.AppDatabase
import com.example.mercadito.repositories.IShopRepo
import com.example.mercadito.repositories.ShopRepository

class ShopListViewModelFactory(
    private val shopRepository: IShopRepo
): ViewModelProvider.Factory {

    constructor(context: Context):this(
        ShopRepository(
            AppDatabase.getDatabase(context)
        )
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopListViewModel::class.java)) {
            return ShopListViewModel(shopRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}