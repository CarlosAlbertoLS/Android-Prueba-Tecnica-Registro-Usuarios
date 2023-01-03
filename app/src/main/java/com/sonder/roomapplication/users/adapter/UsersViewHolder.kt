package com.sonder.roomapplication.users.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sonder.roomapplication.R
import com.sonder.roomapplication.data.User

class UsersViewHolder(view: View): RecyclerView.ViewHolder(view){

    val userName = view.findViewById<TextView>(R.id.tvUserName)
    val image = view.findViewById<ImageView>(R.id.ivUserImage)

    fun render(userModel: User){
        userName.text = userModel.user
        image.setImageBitmap(userModel.image)
    }

}