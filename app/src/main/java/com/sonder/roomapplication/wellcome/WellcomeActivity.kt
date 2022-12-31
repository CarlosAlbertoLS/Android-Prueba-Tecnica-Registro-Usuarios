package com.sonder.roomapplication.wellcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.roomapplication.databinding.ActivityMainBinding
import com.sonder.roomapplication.databinding.ActivityWellcomeBinding

class WellcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWellcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWellcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}