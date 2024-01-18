package com.cynthiawomentechsters.cynthianoteapp.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cynthiawomentechsters.cynthianoteapp.models.Note
import com.cynthiawomentechsters.cynthianoteapp.room.DatabaseConfig
import kotlinx.coroutines.launch
import java.util.Calendar

class NoteViewModel(val applicationn: Application): AndroidViewModel(applicationn) {
   //calling the save function of the database
   private var db = DatabaseConfig.getInstance(applicationn)

    private fun getStartOfDay(currentTimeMillis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = currentTimeMillis
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }
    fun saveNote(title: String, content: String){
        val currentTimeMillis = System.currentTimeMillis()

        if(title.isNullOrEmpty() && content.isNullOrEmpty())return
        //Creating a Note instance
        val note = Note(
            title = title,
            content = content,
            dateTime = System.currentTimeMillis(),
        )

        viewModelScope.launch {
            db.noteDao().saveNote(note)
        }

    }

    fun getAllNotes(): LiveData<List<Note>> {
        return db.noteDao().fetchNotes()
    }

    fun getNote(noteId: String): LiveData<Note>{
        return db.noteDao().fetchNote(noteId)
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            db.noteDao().deleteNote(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch {
            db.noteDao().updateNote(note)
        }
    }
}