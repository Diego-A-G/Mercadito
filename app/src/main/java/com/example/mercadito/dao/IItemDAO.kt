package com.example.mercadito.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mercadito.entities.ItemEntity

@Dao
interface IItemDAO {

    @Insert
    fun insert(item: ItemEntity)

    @Query("SELECT * FROM item WHERE id = :itemId")
    fun getItemById(itemId: Int): ItemEntity


}