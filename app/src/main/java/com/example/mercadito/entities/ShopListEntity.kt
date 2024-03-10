package com.example.mercadito.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopList")
data class ShopListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val items: Int,
    val total: Double,
)


