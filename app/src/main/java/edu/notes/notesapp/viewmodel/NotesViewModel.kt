package edu.notes.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.notes.notesapp.model.NotesRepository
import edu.notes.notesapp.room.entity.NotesEntity

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    var notesRepository : NotesRepository
    var notesLivedata : LiveData<List<NotesEntity>>
    init {
        notesRepository = NotesRepository(application)
        notesLivedata = notesRepository.notesLivedata
    }

    fun addNotes(notes : NotesEntity){
        notesRepository.addNotes(notes)
    }

    fun deleteNotes(id : Int){
        notesRepository.deleteNotes(id)
    }

    fun updateNotes(notes: NotesEntity){
        notesRepository.updateNotes(notes)
    }

//    fun getNotesLiveData() : LiveData<List<NotesEntity>>{
//        return notesLivedata
//    }
}