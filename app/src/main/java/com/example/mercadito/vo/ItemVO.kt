package com.example.mercadito.vo

class ItemVO (
    val id: Int = 0,
    val name: String,
    val cost: Double,
    val description: String,
    val amount: Int,
    val shoplistId: Int // Clave externa para relacionar con la lista de compras
)