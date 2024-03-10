package com.example.mercadito.ui.managers

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mercadito.database.AppDatabase
import com.example.mercadito.repositories.IUserRepo
import com.example.mercadito.repositories.UserRepository

class UserViewModelFactory(
    private val userRepository: IUserRepo
):ViewModelProvider.Factory {

    constructor(context: Context):this(
        UserRepository(
            AppDatabase.getDatabase(context)
        )
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}