package edu.notes.notesapp.bindings.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import edu.notes.notesapp.NoteDetailsActivity
import edu.notes.notesapp.R
import edu.notes.notesapp.bindings.viewholder.NotesViewHolder
import edu.notes.notesapp.room.entity.NotesEntity
import edu.notes.notesapp.utility.toast
import edu.notes.notesapp.view.MainActivity

class NotesAdapter(var context : Context,var notesList : List<NotesEntity>) : RecyclerView.Adapter<NotesViewHolder>(),NotesViewHolder.onItemClickListner {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item,parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int){
        holder.bind(notesList[position])
        holder.onItemClick(holder.constraintLayout!!,context,::onNavigate,position,holder)
        holder.onItemLongClick(holder.constraintLayout!!,context,::onShowBottomPopup,position,holder)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onNavigate(position: Int, holder: NotesViewHolder) {
        val intent = Intent(context,NoteDetailsActivity::class.java)
        context.startActivity(intent)
        (context as MainActivity).finish()
    }

    override fun onShowBottomPopup() {

        val bottomDialog = BottomSheetDialog(context as MainActivity,R.style.BottomSheetStyle)
        bottomDialog.setContentView(R.layout.bottom_popup)
        bottomDialog.setCanceledOnTouchOutside(true)
        bottomDialog.apply {
            BottomSheetBehavior.PEEK_HEIGHT_AUTO
        }
        val noteDeleteButton = bottomDialog.findViewById<ConstraintLayout>(R.id.deleteNoteButton)
        val noteUpdateButton = bottomDialog.findViewById<ConstraintLayout>(R.id.updateNoteButton)
        bottomDialog.show()

        noteUpdateButton?.setOnClickListener {
            toast(context,"notes updated")
        }
        noteDeleteButton?.setOnClickListener {
            toast(context,"notes deleted!!")
        }
    }
}