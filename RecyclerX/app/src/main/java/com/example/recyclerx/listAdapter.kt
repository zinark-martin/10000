package com.example.recyclerx

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//传参: context, 自定义子布局, items数组
class myListAdapter(
    activity: Activity = MainActivity(),
    private val resource: Int,
    list: List<ListItem>
) : ArrayAdapter<ListItem>(activity, resource, list) {

    class ViewHolder(var imageHold: ImageView, var textHold: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //convertView缓存view
        //viewHolder缓存布局里的资源
        /**
         * findViewById()这个方法是比较耗性能的操作，
         * 因为这个方法要找到指定的布局文件，进行不断地解析每个节点：
         * 从最顶端的节点进行一层一层的解析查询，找到后在一层一层的返回
         * */
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resource,parent, false)
            var listImage: ImageView = view.findViewById(R.id.listPic)
            var listTest: TextView = view.findViewById(R.id.listText)
            viewHolder = ViewHolder(listImage,listTest)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        //把item的资源放入holder
        val listItem = getItem(position)
        if (listItem != null) {
            viewHolder.imageHold.setImageResource(listItem.image)
            viewHolder.textHold.text = listItem.name
        }
        return view
    }
}
