package com.example.mercadito.repositories

import com.example.mercadito.database.AppDatabase
import com.example.mercadito.vo.NewsVO

class NewsRepository (
    private val appDatabase: AppDatabase
) :INewsRepo{
    override suspend fun getNews(): List<NewsVO> {
        return listOf(
            NewsVO("La papa subio","potato","la papa esta en 5k la libra"),
            NewsVO("El queso subio","cheese","el queso esta en 15k la libra"),
            NewsVO("El huebo bajo","egg","el huevo esta en 15k la cubeta"),
            NewsVO("La uva subio","grapes","la uva esta en 9k la libra")
        )
    }
}