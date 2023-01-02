package com.sonder.roomapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM `user-table`")
    fun readAllData(): LiveData<User>

    @Query("SELECT EXISTS (SELECT * FROM `user-table` where user=:user and password=:password)")
    suspend fun login(user:String, password: String): Boolean

}