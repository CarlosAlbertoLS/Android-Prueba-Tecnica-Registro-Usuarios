package com.sonder.roomapplication.register

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sonder.roomapplication.data.User
import com.sonder.roomapplication.data.UserDataBase
import com.sonder.roomapplication.data.UserRepository
import com.sonder.roomapplication.login.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val readAllData: LiveData<List<User>>

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun goToLoginActivity(context: Context, user: String) {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("UserName", user)
        context.startActivity(intent)
    }
}