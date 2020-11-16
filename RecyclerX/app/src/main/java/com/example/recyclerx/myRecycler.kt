package com.example.recyclerx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class myRecycler(private val list: List<ListItem>) : RecyclerView.Adapter<myRecycler.ViewHolder>() {
    //ViewHolder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.listPic)
        val text = view.findViewById<TextView>(R.id.listText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myRecycler.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)

        //item的点击事件在viewHolder中设定
        return ViewHolder(view).apply {
            image.setOnClickListener {
                val item = list[adapterPosition]
            }
            text.setOnLongClickListener {
                val item = list[adapterPosition]
                true
            }
        }
    }
    //adapter处理data为viewHolder, 以view的形式传递给RecyclerView(确切说是LayoutManager)
    override fun onBindViewHolder(holder: myRecycler.ViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            image.setImageResource(item.image)
            text.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}