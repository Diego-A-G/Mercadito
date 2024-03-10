package com.example.mercadito.repositories

import com.example.mercadito.entities.HistoricEntity
import com.example.mercadito.entities.ShopListEntity
import com.example.mercadito.vo.HistoricVO
import com.example.mercadito.vo.ShopListVO

interface IShopRepo {
    suspend fun createShopList(shopList: ShopListVO): Boolean

    suspend fun getShopListsByUser(userId: Int): ShopListEntity

    suspend fun saveHistoricShop(historicShop: HistoricVO)

    suspend fun getHistoricShopByUser(userId: String): HistoricEntity
}