package edu.notes.notesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.notes.notesapp.R
import edu.notes.notesapp.bindings.adapter.NotesAdapter
import edu.notes.notesapp.room.entity.NotesEntity
import edu.notes.notesapp.viewmodel.NotesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var notesAddButton : FloatingActionButton
    private lateinit var recyclerview : RecyclerView
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var notesViewModel : NotesViewModel
    private lateinit var notesList : ArrayList<NotesEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        notesAddButton = findViewById(R.id.noteAddButton)
        recyclerview = findViewById(R.id.recyclerview)
        notesList = arrayListOf()

        notesAddButton.setOnClickListener {
            //Toast.makeText(this,"add some notes",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
            finish()
        }

        notesViewModel.notesLivedata.observe(this, Observer { notes ->
            recyclerview.setHasFixedSize(true)
            recyclerview.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            notesAdapter = NotesAdapter(this,notes)
            recyclerview.adapter = notesAdapter

        })


    }
}