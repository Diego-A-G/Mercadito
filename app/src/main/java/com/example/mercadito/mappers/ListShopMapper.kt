package com.example.mercadito.mappers

import com.example.mercadito.entities.ShopListEntity
import com.example.mercadito.vo.ShopListVO

class ListShopMapper {

    fun fromEntity(entity: ShopListEntity): ShopListVO {
        return ShopListVO(
            id = entity.id,
            name = entity.name,
            items = listOf()
        )
    }

    fun toEntity(vo: ShopListVO): ShopListEntity {
        return ShopListEntity(
            id = vo.id,
            name = vo.name,
            items = 0 // Aquí deberías definir cómo manejar la lista de ítems
        )
    }

    fun fromEntityList(entities: List<ShopListEntity>): List<ShopListVO> {
        return entities.map { fromEntity(it) }
    }

    fun toEntityList(vos: List<ShopListVO>): List<ShopListEntity> {
        return vos.map { toEntity(it) }
    }
}