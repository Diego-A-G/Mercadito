package com.example.mercadito.ui.fragments.adapters

import com.example.mercadito.vo.NewsVO

interface IItemTouched {
    fun onItemClick(newsItem: NewsVO)
}
