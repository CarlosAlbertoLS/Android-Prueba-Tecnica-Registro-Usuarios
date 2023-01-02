package com.sonder.roomapplication.register

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import com.sonder.roomapplication.data.User
import com.sonder.roomapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var image: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
                if (result.resultCode == Activity.RESULT_OK){
                    val intent = result.data
                    image = intent?.extras?.get("data") as Bitmap
                    binding.PictureUser.setImageBitmap(image)
                }
            }

        binding.btnUpLoadPicture.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        binding.btnRegisterUser.setOnClickListener { insertDataToDatabase() }
    }

    private fun insertDataToDatabase() {
        val userName = binding.registerUserName.text.toString()
        val age = binding.registerAge.text.toString()
        val birthday = binding.registerBirthday.text.toString()
        val password = binding.registerPassword.text.toString()
        if (inputCheck(userName,age)){
            val user = User(0, userName, age.toInt(), birthday,password, image)
            viewModel.addUser(user)
            Toast.makeText(this, "Successfully added, user $userName password $password", Toast.LENGTH_SHORT).show()
            viewModel.goToLoginActivity(this)
        }else{
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(userName: String,age: String): Boolean{
        return !(TextUtils.isEmpty(userName) && TextUtils.isEmpty(age))
    }
}