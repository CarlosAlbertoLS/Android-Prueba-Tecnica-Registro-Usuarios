package com.sonder.roomapplication.wellcome

import android.app.Application
import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sonder.roomapplication.data.User
import com.sonder.roomapplication.data.UserDataBase
import com.sonder.roomapplication.data.UserRepository
import com.sonder.roomapplication.login.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeViewModel(application: Application): AndroidViewModel(application) {

    val readUserData: LiveData<User>
    private val repository: UserRepository

    private var _age = MutableLiveData("123")
    val age: LiveData<String> = _age

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readUserData = repository.readAllData
    }

    fun goToHome(context: Context) = context.startActivity(Intent(context, MainActivity::class.java))
}