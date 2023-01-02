package com.sonder.roomapplication.data

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user-table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val user: String,
    val age: Int,
    val birthday: String,
    val password: String
)
