package com.example.mercadito.repositories

import com.example.mercadito.database.AppDatabase
import com.example.mercadito.entities.HistoricEntity
import com.example.mercadito.entities.ShopListEntity
import com.example.mercadito.mappers.HistoricMapper
import com.example.mercadito.mappers.ListShopMapper
import com.example.mercadito.vo.HistoricVO
import com.example.mercadito.vo.ShopListVO

class ShopRepository(private val appDatabase: AppDatabase) : IShopRepo {

    override suspend fun createShopList(shopList: ShopListVO): Boolean {
        return try {
            appDatabase.getShopListDao().insert(ListShopMapper().toEntity(shopList))
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getShopListsByUser(userId: Int): ShopListEntity {
        return appDatabase.getShopListDao().getShopListsByUser(userId)
    }

    override suspend fun saveHistoricShop(historicShop: HistoricVO) {
        appDatabase.getHistoricShopDao().insert(HistoricMapper().toEntity(historicShop))
    }

    override suspend fun getHistoricShopByUser(userId: String): HistoricEntity {
        return appDatabase.getHistoricShopDao().getHistoricShopByUser(userId)
    }
}
