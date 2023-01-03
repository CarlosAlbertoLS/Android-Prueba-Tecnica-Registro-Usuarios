package com.sonder.roomapplication.login

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sonder.roomapplication.R
import com.sonder.roomapplication.data.UserDataBase
import com.sonder.roomapplication.data.UserRepository
import com.sonder.roomapplication.register.RegisterActivity
import com.sonder.roomapplication.users.UsersActivity
import com.sonder.roomapplication.wellcome.WellcomeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun goToRegisterActivity(context: Context){
        val intent = Intent(context, RegisterActivity::class.java)
        context.startActivity(intent)
    }

    fun login(user:String, password:String, context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            if (repository.login(user, password)) {
                val intent = Intent(context, WellcomeActivity::class.java)
                intent.putExtra("EXTRA_USER", user)
                context.startActivity(intent)
            } else {
                viewModelScope.launch(Dispatchers.Main) {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle(R.string.error)
                    builder.setMessage(R.string.errorLogin)
                    builder.setPositiveButton(R.string.ok, null)
                    builder.show()
                }
            }
        }
    }

    fun goToGetUsers(context: Context) = context.startActivity(Intent(context, UsersActivity::class.java))
}