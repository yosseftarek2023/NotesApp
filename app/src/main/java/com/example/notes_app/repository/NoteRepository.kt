package com.example.notes_app.repository

import com.example.notes_app.database.NoteDatabase
import com.example.notes_app.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insert(note:Note) = db.getNoteDao().insert(note)
    suspend fun update(note:Note) = db.getNoteDao().update(note)
    suspend fun delete(note:Note) = db.getNoteDao().delete(note)

    fun getAllnotes() = db.getNoteDao().getAllNotes()
    fun searchNotes(query:String?) = db.getNoteDao().searchNote(query)


}