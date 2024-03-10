package com.example.mercadito.repositories

import com.example.mercadito.database.AppDatabase
import com.example.mercadito.vo.NewsVO

class NewsRepository ( private val appDatabase: AppDatabase
) :INewsRepo{
    override suspend fun getNews(): List<NewsVO> {
        //consumo web , apicall
        return listOf()
    }
}