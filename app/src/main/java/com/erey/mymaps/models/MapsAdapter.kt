package com.erey.mymaps.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MapsAdapter (val context: Context, val userMaps: List<UserMap>, val onClickLsitener: OnClickLsitener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnClickLsitener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener({
            onClickLsitener.onItemClick(position)
        })
        val textViewTitle = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text = userMap.title
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}