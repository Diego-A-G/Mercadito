package com.example.mercadito.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mercadito.entities.HistoricEntity

@Dao
interface IHistoricDAO {

    @Insert
    fun insert(historicShop: HistoricEntity)

    @Query("SELECT * FROM historic_shop WHERE id = :historicShopId")
    fun getHistoricShopById(historicShopId: Int): HistoricEntity
    @Query("SELECT * FROM historic_shop WHERE userId = :userId")
    fun getHistoricShopByUser(userId: String): HistoricEntity

}