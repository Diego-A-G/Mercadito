package com.example.mercadito.repositories

import com.example.mercadito.vo.NewsVO

interface INewsRepo {

    suspend fun getNews():List<NewsVO>

}
