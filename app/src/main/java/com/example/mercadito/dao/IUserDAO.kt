package com.example.mercadito.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mercadito.entities.UserEntity

@Dao
interface IUserDAO {

    @Insert
    fun insert(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserById(userId: Int): UserEntity

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserByEmail(email: String): UserEntity
}