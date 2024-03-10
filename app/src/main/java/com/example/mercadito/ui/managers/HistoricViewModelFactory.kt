package com.example.mercadito.ui.managers

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mercadito.database.AppDatabase
import com.example.mercadito.repositories.IShopRepo
import com.example.mercadito.repositories.ShopRepository

class HistoricViewModelFactory(
    private val shopRepo: IShopRepo
): ViewModelProvider.Factory {

    constructor(context: Context):this(
        ShopRepository(
            AppDatabase.getDatabase(context)
        )
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoricViewModel::class.java)) {
            return HistoricViewModel(shopRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}