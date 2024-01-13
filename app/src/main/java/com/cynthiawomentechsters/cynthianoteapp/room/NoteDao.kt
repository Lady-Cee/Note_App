package com.cynthiawomentechsters.cynthianoteapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cynthiawomentechsters.cynthianoteapp.models.Note

//import necessary room packages
// import dao(data access office
//define table
//search for relational db
@Dao
interface NoteDao {
    @Insert
    suspend fun saveNote(note: Note)
//    {
//        if (note.title.isNotEmpty() && note.content.isNotEmpty()) {
//            saveNote(note)
//        }
//    }


    @Query("Select * from notes")
    fun fetchNotes(): LiveData<List<Note>>

}