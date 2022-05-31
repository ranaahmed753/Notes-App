package edu.notes.notesapp.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "category")
    val notesCategory : String,
    @ColumnInfo(name = "notesTitle")
    val notesTitle : String,
    @ColumnInfo(name = "notesBody")
    val notesBody : String,
    @ColumnInfo(name = "notesDate")
    val notesDate : String
)