package edu.notes.notesapp.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.notes.notesapp.room.dao.NotesDao
import edu.notes.notesapp.room.entity.NotesEntity

@Database(entities = [NotesEntity::class],version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun getNotesDao() : NotesDao

    companion object{
        var notesDatabase : NotesDatabase ? = null
        fun getNotesDatabase(context: Context) : NotesDatabase{
            if(notesDatabase == null){
                notesDatabase = Room.databaseBuilder<NotesDatabase>(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "notesDB"
                ).allowMainThreadQueries().build()
            }
            return notesDatabase!!
        }
    }
}