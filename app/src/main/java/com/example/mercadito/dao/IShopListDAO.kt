package com.example.mercadito.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mercadito.entities.ShopListEntity

@Dao
interface IShopListDAO {

    @Insert
    fun insert(shopList: ShopListEntity)

    @Query("SELECT * FROM shopList WHERE id = :shopListId")
    fun getShopListById(shopListId: Int): ShopListEntity

    @Query("SELECT * FROM shopList WHERE id = :userId")
    fun getShopListsByUser(userId: Int): ShopListEntity

}