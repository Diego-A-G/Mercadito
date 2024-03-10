package com.example.mercadito.mappers

import com.example.mercadito.entities.HistoricEntity
import com.example.mercadito.vo.HistoricVO

class HistoricMapper {

    fun fromEntity(entity: HistoricEntity): HistoricVO {
        return HistoricVO(
            id = entity.id,
            //shopList = entity.listShops.map { ListShopMapper().fromEntity(it) }
            shopList = listOf(),
            userId = 0
        )
    }

    fun toEntity(vo: HistoricVO): HistoricEntity {
        return HistoricEntity(
            id = vo.id,
            //listShops = vo.shopList.map { ListShopMapper().toEntity(it) }
            listShops = 0,
            userId = 0
        )
    }

    fun fromEntityList(entities: List<HistoricEntity>): List<HistoricVO> {
        return entities.map { fromEntity(it) }
    }

    fun toEntityList(vos: List<HistoricVO>): List<HistoricEntity> {
        return vos.map { toEntity(it) }
    }
}
