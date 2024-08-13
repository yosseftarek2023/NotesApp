package com.example.notes_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes_app.model.Note
import com.example.notes_app.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app :Application,private val noteRepository: NoteRepository):AndroidViewModel(app) {

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.insert(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.update(note)
    }
    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.delete(note)
    }
    fun getAllNotes() = noteRepository.getAllnotes()
    fun searchNotes(query:String?) = noteRepository.searchNotes(query)
}