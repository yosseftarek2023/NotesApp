package com.example.notes_app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notes_app.model.Note


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("Select * from Notes where noteTitle LIKE :query or noteDescription like :query")
    fun searchNote(query:String?) : LiveData<List<Note>>
}