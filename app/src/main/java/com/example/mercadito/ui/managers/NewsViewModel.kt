package com.example.mercadito.ui.managers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mercadito.repositories.INewsRepo
import com.example.mercadito.vo.NewsVO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: INewsRepo
): ViewModel(){

    //todo handler

    private var scope = CoroutineScope(Dispatchers.IO)

    private val news = MutableLiveData<List<NewsVO>>().apply { value = listOf() }
    fun getNews():LiveData<List<NewsVO>> = news

    fun fetchNews(){
        scope.launch {
            val response = newsRepository.getNews()
            news.postValue(response)
        }
    }



}
