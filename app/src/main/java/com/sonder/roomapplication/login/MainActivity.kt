package com.sonder.roomapplication.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sonder.roomapplication.databinding.ActivityMainBinding
//TODO CORREGIR LOS EDIT TEXT PARA QUE SOLO SEA UNA LINEA ✔️
//TODO DISEAR LA PANTALLA WELCOME ✔
//TODO COLOCAR LOS DATOS DE LA DB EN LA PANTALLA WELCOME ✔
//TODO PROBAR GUARDAR DATOS CON LA IMAGEN
//TODO COLOCAR IMAGEN EN LA PANTALLA WELCOME
//TODO MEJORAR EL DISEO DE LA APP
//TODO AGREGAR FUNCIONALIDAD EXTRA

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener { viewModel.goToRegisterActivity(this) }

        binding.btnLogin.setOnClickListener { login() }
    }

    private fun login() {
        val user = binding.loginUser.text.toString()
        val password = binding.loginPassword.text.toString()
        if (!(user.isNullOrBlank() || password.isNullOrBlank())){
            viewModel.login(user,password, this)
            Toast.makeText(this,"$user, $password", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}