package com.sonder.roomapplication.wellcome

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sonder.roomapplication.R
import com.sonder.roomapplication.databinding.ActivityWellcomeBinding

class WellcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWellcomeBinding
    private val viewModel: WelcomeViewModel by viewModels()
    private lateinit var welcomeViewModel: WelcomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWellcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.extras?.getString("EXTRA_USER")!!

        title = "${getString(R.string.wellcome)} ${user.uppercase()}"
        welcomeViewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        welcomeViewModel.readUserData.observe(this, Observer { user ->
            val photo:Bitmap? = user.image
            binding.welcomePhoto.setImageBitmap(photo)
            binding.welcomeAge.text = user.age.toString()
            binding.welcomeBirthday.text = user.birthday.toString()
        })

        binding.btnLogOut.setOnClickListener { viewModel.goToHome(this) }
    }
}