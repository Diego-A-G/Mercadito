package com.example.mercadito.ui.managers

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mercadito.database.AppDatabase
import com.example.mercadito.repositories.INewsRepo
import com.example.mercadito.repositories.NewsRepository

class NewsViewModelFactory(
    private val newsRepository: INewsRepo
): ViewModelProvider.Factory {

    constructor(context: Context):this(
        NewsRepository(
            AppDatabase.getDatabase(context)
        )
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}