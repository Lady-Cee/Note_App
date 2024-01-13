package com.cynthiawomentechsters.cynthianoteapp.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cynthiawomentechsters.cynthianoteapp.models.Note
import com.cynthiawomentechsters.cynthianoteapp.room.DatabaseConfig
import kotlinx.coroutines.launch

class NoteViewModel(val applicationn: Application): AndroidViewModel(applicationn) {
    val db = DatabaseConfig.getInstance(applicationn)

    fun saveNote(title: String, content: String) {
        //creating a note instance
        val note = Note(
            title = title,
            content = content
        )
        //calling the save function of the database


        viewModelScope.launch {
            //Perform the database operation(insert, update etc using appDatabase
            db.noteDao().saveNote(note)
        }

    }

    fun getAllNotes(): LiveData<List<Note>>{
        return db.noteDao().fetchNotes()
    }
}