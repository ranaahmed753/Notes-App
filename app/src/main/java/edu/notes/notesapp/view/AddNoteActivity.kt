package edu.notes.notesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import edu.notes.notesapp.R
import edu.notes.notesapp.room.entity.NotesEntity
import edu.notes.notesapp.utility.toast
import edu.notes.notesapp.viewmodel.NotesViewModel
import java.lang.String.format
import java.text.DateFormat
import java.text.MessageFormat.format
import java.util.*

class AddNoteActivity : AppCompatActivity() {
    private lateinit var category : EditText
    private lateinit var title : EditText
    private lateinit var body : EditText
    private lateinit var addNoteButton : ConstraintLayout
    private lateinit var notesViewModel : NotesViewModel
    private lateinit var backButton : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_note)
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        category = findViewById(R.id.cagegory)
        title = findViewById(R.id.title)
        body = findViewById(R.id.body)
        addNoteButton = findViewById(R.id.addNoteButton)
        backButton = findViewById(R.id.backButton)
        addNoteButton.setOnClickListener {
            if(TextUtils.isEmpty(category.text.toString()) || TextUtils.isEmpty(title.text.toString()) || TextUtils.isEmpty(body.text.toString())){
                toast(this,"some fields are empty!!")
            }else{
                notesViewModel.addNotes(NotesEntity(0,category.text.toString(),title.text.toString(),body.text.toString(),"20 april 2022"))
                toast(this,"notes created successfully")
            }

        }

        backButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}