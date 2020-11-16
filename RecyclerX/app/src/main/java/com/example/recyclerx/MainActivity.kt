package com.example.recyclerx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testcase = listOf<ListItem>(ListItem("jack", R.drawable.ic_launcher_background))
        //ListView
        listView.adapter = myListAdapter(this,R.layout.list, testcase)
        listView.setOnItemClickListener { _, _, position, id ->
            val item = testcase[position]
        }
        //RecyclerView
        recyclerView.apply {
            adapter = myRecycler(testcase)
            layoutManager =
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        }
    }
}