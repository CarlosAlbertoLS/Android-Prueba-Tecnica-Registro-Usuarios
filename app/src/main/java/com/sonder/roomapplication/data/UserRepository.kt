package com.sonder.roomapplication.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    val readAllDataUser: LiveData<User> = userDao.readAllDataUser()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun login(user:String, password: String): Boolean{
        return userDao.login(user, password)
    }
}