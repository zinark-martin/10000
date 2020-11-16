package com.example.quicknote.AddNotes.Notes.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.quicknote.Model.Notes
import com.example.quicknote.Repo.NotesRepo

class NotesViewModel(private val notesRepo: NotesRepo) : ViewModel() {

    // 因为AutoGenerate = true SQLite语言会自动生成一个独一无二的id
    // 所以插入新笔记不需要id
    // 但是其它的方法是对已有的笔记进行操作,所以就需要获取id,再给方法传入id,然后以三个全参数实例一个笔记Entity作参数给dao
    fun insertNotes(taskName: String, taskDesc: String) = viewModelScope.launch {
        val notes = Notes(
            title = taskName,
            description = taskDesc
        )
        notesRepo.insert(notes)
    }

    fun updateNotes(id: Int, taskName: String, taskDesc: String) = viewModelScope.launch {
        val notes = Notes(
            id = id,
            title = taskName,
            description = taskDesc
        )
        notesRepo.update(notes)
    }

    fun getSavedNotes() = notesRepo.getSavedNotes()

    fun deleteNotes(taskID: Int, taskName: String, taskDesc: String) = viewModelScope.launch {
        val notes = Notes(
            id = taskID,
            title = taskName,
            description = taskDesc
        )
        notesRepo.deleteNotes(notes)
    }

}