package com.example.mercadito.mappers

import com.example.mercadito.entities.UserEntity
import com.example.mercadito.vo.UserVO

class UserMapper {

    fun fromEntity(entity: UserEntity): UserVO {
        return UserVO(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            password = entity.password,
            alias = entity.alias
        )
    }

    fun toEntity(vo: UserVO): UserEntity {
        return UserEntity(
            id = vo.id,
            name = vo.name,
            email = vo.email,
            password = vo.password,
            alias = vo.alias
        )
    }

    fun fromEntityList(entities: List<UserEntity>): List<UserVO> {
        return entities.map { fromEntity(it) }
    }

    fun toEntityList(vos: List<UserVO>): List<UserEntity> {
        return vos.map { toEntity(it) }
    }
}