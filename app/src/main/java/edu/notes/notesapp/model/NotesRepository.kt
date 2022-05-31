package edu.notes.notesapp.model
import android.app.Application
import androidx.lifecycle.LiveData
import edu.notes.notesapp.room.dao.NotesDao
import edu.notes.notesapp.room.database.NotesDatabase
import edu.notes.notesapp.room.entity.NotesEntity

class NotesRepository(application: Application) {
    var notesDao : NotesDao
    var notesDatabase : NotesDatabase
    var notesLivedata : LiveData<List<NotesEntity>>
    init {
        notesDatabase = NotesDatabase.getNotesDatabase(application)
        notesDao = notesDatabase.getNotesDao()
        notesLivedata = notesDao.getAllNotes()
    }

    fun getAllNotes(){

    }

    fun addNotes(notes : NotesEntity){
        notesDao.addNotes(notes)
    }

    fun deleteNotes(id : Int){
        notesDao.deleteNotes(id)
    }

    fun updateNotes(notes : NotesEntity){
        notesDao.updateNotes(notes)
    }
}