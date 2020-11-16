package com.example.quicknote.Repo

import com.example.quicknote.DB.NotesDatabase
import com.example.quicknote.Model.Notes


class NotesRepo(private val db: NotesDatabase) {

    suspend fun insert(notes: Notes) = db.getNotesDao().insertNotes(notes)

    suspend fun update(notes: Notes) = db.getNotesDao().updateNotes(notes)

    fun getSavedNotes() = db.getNotesDao().getNotes()

    suspend fun deleteNotes(notes: Notes) = db.getNotesDao().deleteNotes(notes)

}