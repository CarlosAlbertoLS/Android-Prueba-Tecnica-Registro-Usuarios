package com.sonder.roomapplication.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sonder.roomapplication.R
import com.sonder.roomapplication.data.User

class UsersAdapter: RecyclerView.Adapter<UsersViewHolder>()  {
    private var usersList = emptyList<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsersViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val item = usersList[position]
        holder.render(item)
    }

    override fun getItemCount() = usersList.size

    fun setData(user: List<User>){
        this.usersList = user
        notifyDataSetChanged()
    }
}