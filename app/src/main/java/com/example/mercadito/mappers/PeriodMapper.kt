package com.example.mercadito.mappers

import com.example.mercadito.entities.PeriodEntity
import com.example.mercadito.vo.PeriodVO

class PeriodMapper {

    fun fromEntity(entity: PeriodEntity): PeriodVO {
        return PeriodVO(
            id = entity.id,
            start = entity.start,
            end = entity.end
        )
    }

    fun toEntity(vo: PeriodVO): PeriodEntity {
        return PeriodEntity(
            id = vo.id,
            start = vo.start,
            end = "",
            userId = 0
        )
    }

    fun fromEntityList(entities: List<PeriodEntity>): List<PeriodVO> {
        return entities.map { fromEntity(it) }
    }

    fun toEntityList(vos: List<PeriodVO>): List<PeriodEntity> {
        return vos.map { toEntity(it) }
    }
}
