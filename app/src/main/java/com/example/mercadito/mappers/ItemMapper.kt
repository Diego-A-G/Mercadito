package com.example.mercadito.mappers

import com.example.mercadito.entities.ItemEntity
import com.example.mercadito.vo.ItemVO

class ItemMapper {

    fun fromEntity(entity: ItemEntity): ItemVO {
        return ItemVO(
            id = entity.id,
            name = entity.name,
            cost = entity.cost,
            description = entity.description,
            amount = entity.amount,
            //shoplistId = 0
        )
    }

    fun toEntity(vo: ItemVO): ItemEntity {
        return ItemEntity(
            id = vo.id,
            name = vo.name,
            cost = vo.cost,
            description = vo.description,
            amount = vo.amount,
            //shoplistId = vo.shoplistId
        )
    }

    fun fromEntityList(entities: List<ItemEntity>): List<ItemVO> {
        return entities.map { fromEntity(it) }
    }

    fun toEntityList(vos: List<ItemVO>): List<ItemEntity> {
        return vos.map { toEntity(it) }
    }
}
