package com.example.quicknote.AddNotes.Notes.ViewModelProviders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quicknote.Repo.NotesRepo
import com.example.quicknote.AddNotes.Notes.ViewModels.NotesViewModel

class MyViewModelFactory(private val notesRepo: NotesRepo) : ViewModelProvider.Factory {
    //实现接口
    //需要自己写实例化 ViewModel 对象实例化的方法
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotesViewModel(notesRepo) as T
    }

}