package com.example.mercadito.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "period")
data class PeriodEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val start: String,
    val end: String,
    val userId: Int
)
