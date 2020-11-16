package com.example.quicknote.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post_notes.view.*
import com.example.quicknote.Model.Notes
import com.example.quicknote.R

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesVH>() {

    inner class NotesVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    //自定义计算差异, 最后只刷新产生变动的item
    val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Notes>() {
        //使用id判断标题是否一样
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem.id == newItem.id
        }
        //并没有重写equals(比较两个对象的HashCode是否相似) 重写方法走个流程
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem == newItem
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = NotesVH(LayoutInflater.from(parent.context).inflate(R.layout.item_post_notes, parent, false))


    override fun getItemCount()
            = differ.currentList.size


    override fun onBindViewHolder(holder: NotesVH, position: Int) {

        val item = differ.currentList[position]
        holder.itemView.apply {
            item_notes_title.text = item.title
            item_notes_desc.text = item.description

            // on item click listener
            setOnClickListener {
                onItemClickListener?.let {
                    it(item)
                }
            }
        }

    }


    // on item click listener
    private var onItemClickListener: ((Notes) -> Unit)? = null
    fun setOnItemClickListener(listener: (Notes) -> Unit) {
        onItemClickListener = listener
    }

}