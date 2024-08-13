package com.example.notes_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notes_app.database.NoteDatabase
import com.example.notes_app.repository.NoteRepository
import com.example.notes_app.viewmodel.NoteViewModel
import com.example.notes_app.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var notesViewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createViewModel()
    }

    private fun createViewModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application,noteRepository)
        notesViewModel = ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}