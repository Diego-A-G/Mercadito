package com.example.mercadito.repositories

import com.example.mercadito.database.AppDatabase
import com.example.mercadito.entities.PeriodEntity
import com.example.mercadito.entities.UserEntity

class UserRepository(
    private val appDatabase: AppDatabase
) : IUserRepo {

    override fun createUser(user: UserEntity): Boolean {
        return try {
            appDatabase.getUserDao().insert(user)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getUserByEmail(email: String): UserEntity {
        return appDatabase.getUserDao().getUserByEmail(email)
    }

    override fun createPeriod(period: PeriodEntity) {
        appDatabase.getPeriodDao().insert(period)
    }

    override fun getPeriodById(id: Int): PeriodEntity {
        return appDatabase.getPeriodDao().getPeriodById(id)
    }
}
