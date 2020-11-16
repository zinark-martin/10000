package com.example.quicknote.AddNotes.NotesDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_notes_details.*
import com.example.quicknote.MainActivity
import com.example.quicknote.AddNotes.Notes.ViewModels.NotesViewModel
import com.example.quicknote.R
import com.example.quicknote.utils.toast

class NotesDetailsFragment : Fragment(R.layout.fragment_notes_details) {

    private lateinit var viewModel: NotesViewModel
    // 也不一定要委托出来, 只要你xml里面指定了args, 编译时候(每一次都)会自动依照xml里面规定的arg属性
    // 名称, 自动生成xxxFragmentArgs类, 所以直接使用类名即可
    //private val args: NotesDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        //不使用getActivity的话这样写: viewModel =  MainActivity().viewModel
        //val notes = args.notes
        val notes = arguments?.let { NotesDetailsFragmentArgs.fromBundle(it).notes }
        val id = notes?.id!!.toInt()
        edit_title.setText(notes.title)
        edit_content.setText(notes.description)


        update_btn_save_notes.setOnClickListener {

            val title = edit_title.text.toString().trim()
            val description = edit_content.text.toString().trim()

            viewModel.updateNotes(id, title, description).also {
                findNavController().navigate(R.id.action_notesDetailsFragment_to_notesFragment)
                requireActivity().toast("已更新笔记")
            }
        }

    }
}