package com.example.quicknote.AddNotes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_notes_fragment.*
import com.example.quicknote.MainActivity
import com.example.quicknote.AddNotes.Notes.ViewModels.NotesViewModel
import com.example.quicknote.R
import com.example.quicknote.utils.toast

class AddNotesFragment : Fragment(R.layout.add_notes_fragment) {

    private lateinit var viewModel: NotesViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        // 保存笔记进数据库
        btn_save_notes.setOnClickListener {
            val title = note_title.text.toString().trim()
            val description = note_content.text.toString().trim()

            // 笔记判空检测
            when {
                title.isEmpty() -> {
                    requireActivity().toast("要写标题哦")
                }
                description.isEmpty() -> {
                    requireActivity().toast("还没写内容呢")
                }
                else -> {
                    viewModel.insertNotes(title, description).also {
                        requireActivity().toast("笔记已保存").also {
                            findNavController().navigate(R.id.action_addNotesFragment_to_notesFragment)
                        }
                    }
                }
            }
        }

    }
}