package com.sonder.roomapplication.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sonder.roomapplication.R
import com.sonder.roomapplication.data.User
import com.sonder.roomapplication.register.RegisterViewModel
import com.sonder.roomapplication.users.adapter.UsersAdapter

class UsersActivity : AppCompatActivity() {
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        inittRecyclerView()
    }

    private fun inittRecyclerView() {
        val adapter = UsersAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rvUsers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewModel.readAllData.observe(this, Observer { user ->
            adapter.setData(user)
        })
    }

}