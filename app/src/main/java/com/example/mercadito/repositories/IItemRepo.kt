package com.example.mercadito.repositories

import com.example.mercadito.entities.CategoryEntity
import com.example.mercadito.entities.ItemEntity
import com.example.mercadito.vo.CategoryVO
import com.example.mercadito.vo.ItemVO

sealed interface IItemRepo{

    suspend fun createItem(item: ItemVO)

    suspend fun getItemsByShopList(shopListId: Int, userId: String): List<ItemEntity>

    suspend fun createCategory(category: CategoryVO)

    suspend fun getCategories(): List<CategoryEntity>

}