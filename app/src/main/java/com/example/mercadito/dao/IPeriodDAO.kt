package com.example.mercadito.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mercadito.entities.PeriodEntity

@Dao
interface IPeriodDAO {

    @Insert
    fun insert(period: PeriodEntity)

    @Query("SELECT * FROM period WHERE id = :periodId")
    fun getPeriodById(periodId: Int): PeriodEntity
}