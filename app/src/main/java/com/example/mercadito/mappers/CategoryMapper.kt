package com.example.mercadito.mappers

import com.example.mercadito.entities.CategoryEntity
import com.example.mercadito.vo.CategoryVO

class CategoryMapper {

    fun fromEntity(entity: CategoryEntity): CategoryVO {
        return CategoryVO(
            id = entity.id,
            name = entity.name,
            description = entity.description
        )
    }

    fun toEntity(vo: CategoryVO): CategoryEntity {
        return CategoryEntity(
            id = vo.id,
            name = vo.name,
            description = vo.description,
            createdBy = 0
        )
    }

    fun fromEntityList(entities: List<CategoryEntity>): List<CategoryVO> {
        return entities.map { fromEntity(it) }
    }

    fun toEntityList(vos: List<CategoryVO>): List<CategoryEntity> {
        return vos.map { toEntity(it) }
    }
}
