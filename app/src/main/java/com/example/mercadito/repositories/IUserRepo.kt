package com.example.mercadito.repositories

import com.example.mercadito.entities.PeriodEntity
import com.example.mercadito.entities.UserEntity

interface IUserRepo {
    fun createUser(user: UserEntity): Boolean

    fun getUserByEmail(email: String): UserEntity?

    fun createPeriod(period: PeriodEntity)

    fun getPeriodById(id: Int): PeriodEntity
}