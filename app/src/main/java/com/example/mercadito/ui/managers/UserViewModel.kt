package com.example.mercadito.ui.managers

import androidx.lifecycle.ViewModel
import com.example.mercadito.repositories.IUserRepo

class UserViewModel(
    private val userRepository: IUserRepo
): ViewModel(){

}