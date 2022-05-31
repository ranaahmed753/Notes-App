package edu.notes.notesapp.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import edu.notes.notesapp.room.entity.NotesEntity

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNotes() : LiveData<List<NotesEntity>>

    @Insert
    fun addNotes(notes : NotesEntity)

    @Query("DELETE FROM notes_table WHERE id=:id")
    fun deleteNotes(id : Int)

    @Update
    fun updateNotes(notes : NotesEntity)

    @Query("SELECT * FROM notes_table WHERE category LIKE :searchQuery")
    fun searchNotes(searchQuery : String) : List<NotesEntity>
}