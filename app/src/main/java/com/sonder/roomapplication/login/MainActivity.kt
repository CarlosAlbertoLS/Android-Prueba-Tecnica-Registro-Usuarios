package com.sonder.roomapplication.login

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sonder.roomapplication.R
import com.sonder.roomapplication.databinding.ActivityMainBinding
//TODO CORREGIR LOS EDIT TEXT PARA QUE SOLO SEA UNA LINEA ✔️
//TODO DISEAR LA PANTALLA WELCOME ✔
//TODO COLOCAR LOS DATOS DE LA DB EN LA PANTALLA WELCOME ✔
//TODO PROBAR GUARDAR DATOS CON LA IMAGEN ✔
//TODO COLOCAR IMAGEN EN LA PANTALLA WELCOME ✔
//TODO MEJORAR EL DISEÑO DE LA APP
//TODO AGREGAR FUNCIONALIDAD EXTRA

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName : String= intent.extras?.getString("UserName") ?: ""

        binding.btnRegister.setOnClickListener {
            viewModel.goToRegisterActivity(this)
            finish()
        }

        binding.btnLogin.setOnClickListener { login() }

        binding.btnUsers.setOnClickListener {
            viewModel.goToGetUsers(this)
        }

        userRegister(userName)
    }

    private fun userRegister(userName: String) {
        if (!userName.isNullOrBlank()){
            binding.loginUser.setText(userName)
            binding.btnLogin.background.setTint(ContextCompat.getColor(this, R.color.buttonLogin))
        }
    }

    private fun login() {
        var user = binding.loginUser.text.toString()
        var password = binding.loginPassword.text.toString()
        if (!(user.isNullOrBlank() || password.isNullOrBlank())){
            viewModel.login(user,password, this)
            binding.loginUser.setText("")
            binding.loginPassword.setText("")
            Toast.makeText(this,"$user, $password", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}