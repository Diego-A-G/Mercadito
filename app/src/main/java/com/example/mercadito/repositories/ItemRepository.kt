package com.example.mercadito.repositories

import com.example.mercadito.database.AppDatabase
import com.example.mercadito.entities.CategoryEntity
import com.example.mercadito.entities.ItemEntity
import com.example.mercadito.mappers.CategoryMapper
import com.example.mercadito.mappers.ItemMapper
import com.example.mercadito.vo.CategoryVO
import com.example.mercadito.vo.ItemVO

class ItemRepository(
    private val appDatabase: AppDatabase
) : IItemRepo {

    override suspend fun createItem(item: ItemVO) {
        // Lógica para crear un nuevo item en la base de datos
        // Retorna true si la operación fue exitosa, de lo contrario false
        try {
            appDatabase.getItemDao().insert(ItemMapper().toEntity(item))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun getItemsByShopList(shopListId: Int, userId: String): List<ItemEntity> {
        // Lógica para obtener los items de una lista de compras específica
        //return appDatabase.getShopListDao().getShopListById(shopListId).items
        return listOf()
    }

    override suspend fun createCategory(category: CategoryVO) {
        // Lógica para crear una nueva categoría en la base de datos
        try {
            appDatabase.getCategoryDao().insert(CategoryMapper().toEntity(category))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun getCategories(): List<CategoryEntity> {
        // Lógica para obtener todas las categorías de la base de datos
        return appDatabase.getCategoryDao().getAllCategories()
    }
}
