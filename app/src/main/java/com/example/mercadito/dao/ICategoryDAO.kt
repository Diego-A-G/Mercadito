package com.example.mercadito.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mercadito.entities.CategoryEntity

@Dao
interface ICategoryDAO {

    @Insert
    fun insert(category: CategoryEntity)

    @Query("SELECT * FROM category WHERE id = :categoryId")
    fun getCategoryById(categoryId: Int): CategoryEntity

    @Query("SELECT * FROM category")
    fun getAllCategories():List<CategoryEntity>
}