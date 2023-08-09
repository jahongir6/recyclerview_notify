package com.example.rvnotify.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.rvnotify.databinding.ItemRvBinding
import com.example.rvnotify.model.User

class RvAdapter(var list: ArrayList<User> = ArrayList(), var rvClick: RvClick) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(user: User, position: Int) {
            itemRvBinding.tvName.text = user.name
            itemRvBinding.tvAge.text = user.age.toString()
            itemRvBinding.root.setOnLongClickListener {
                rvClick.onClick(user, position)
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun onClick(user: User, position: Int)
    }

}