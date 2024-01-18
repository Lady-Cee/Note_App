package com.cynthiawomentechsters.cynthianoteapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.OnConflictStrategy
import com.cynthiawomentechsters.cynthianoteapp.models.Note

//import necessary room packages
// import dao(data access office
//define table
//search for relational db
@Dao
interface NoteDao {
    @Insert
      //  (onConflict = onConflictStrategy.ABORT)
    suspend fun saveNote(note: Note)

    // retrieving all the notes from database
    @Query("Select * from notes order by id desc")
    fun fetchNotes(): LiveData<List<Note>>

    // retriving notes by id
    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun fetchNote(noteId: String): LiveData<Note>


    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

}