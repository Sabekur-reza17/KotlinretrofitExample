package com.sabekur2017.kotlinretrofitexample.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sabekur2017.kotlinretrofitexample.R
import com.sabekur2017.kotlinretrofitexample.model.User
import kotlinx.android.synthetic.main.item_recycler.view.*


class MainAdapter(private val users:ArrayList<User>):
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_recycler,parent,false
        )
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
       return holder.bind(users[position])
    }

    override fun getItemCount(): Int {
      return users.size
    }
    fun addData(list:List<User>){
        users.addAll(list)
    }
    class DataViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
            itemView.textViewUserName.text=user.name
            itemView.textViewUserEmail.text=user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }
    }

}