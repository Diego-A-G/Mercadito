package com.example.mercadito.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historic_shop")
data class HistoricEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val listShops: Int,
    val userId: Int
)



