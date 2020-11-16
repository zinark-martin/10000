package com.example.quicknote.AddNotes.Notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.notes_fragment.*
import com.example.quicknote.Adapter.NotesAdapter
import com.example.quicknote.MainActivity
import com.example.quicknote.AddNotes.Notes.ViewModels.NotesViewModel
import com.example.quicknote.R

class NotesFragment : Fragment(R.layout.notes_fragment) {
    private lateinit var viewModel: NotesViewModel
    private lateinit var notesAdapter: NotesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
                // recyclerView
        notesAdapter = NotesAdapter()
        notes_rv.apply {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        // 添加note
        btn_add_notes.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addNotesFragment)
        }

        //获取返回的liveData(list)对象传递给differ来计算替换recyclerView的list
        viewModel.getSavedNotes().observe(viewLifecycleOwner) {
                notes -> notesAdapter.differ.submitList(notes)
        }

        // 添加新笔记
        notesAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("notes", it)
            }
            findNavController().navigate(
                R.id.action_notesFragment_to_notesDetailsFragment,
                bundle
            )
        }

        // 创建侧滑点击事件(callback太长了故单独实例化出来)
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // 获取选择的item
                val position = viewHolder.adapterPosition
                val notes = notesAdapter.differ.currentList[position]
                // 删除笔记
                viewModel.deleteNotes(
                    notes.id!!.toInt(),
                    notes.title.toString(),
                    notes.description.toString()
                )
                Snackbar.make(view, "成功删除笔记", Snackbar.LENGTH_LONG).apply {
                    setAction("撤销") {
                        viewModel.insertNotes(notes.title.toString(), notes.description.toString())
                    }
                    show()
                }
            }
        }
        // 把上面的侧滑callback实例attach到RV
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(notes_rv)

    }
}