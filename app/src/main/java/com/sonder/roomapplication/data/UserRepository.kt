package com.sonder.roomapplication.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val reasAllData: LiveData<User> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun login(user:String, password: String): Boolean{
        return userDao.login(user, password)
    }
}