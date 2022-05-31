package edu.notes.notesapp.bindings.viewholder

import android.content.Context
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import edu.notes.notesapp.R
import edu.notes.notesapp.room.entity.NotesEntity
import edu.notes.notesapp.utility.toast

class NotesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var category : TextView? = null
    var title : TextView? = null
    var date : TextView? = null
    var constraintLayout : ConstraintLayout? = null
    init {
        category = itemView.findViewById(R.id.category)
        title = itemView.findViewById(R.id.title)
        date = itemView.findViewById(R.id.date)
        constraintLayout = itemView.findViewById(R.id.constraintLayout)
    }

    fun bind(notes : NotesEntity){
        category?.text = notes.notesCategory
        title?.text = notes.notesTitle
        date?.text = notes.notesDate
    }

    fun onItemClick(widget : ConstraintLayout, context: Context, onDoSomething : (position : Int, holder : NotesViewHolder) -> Unit, position: Int, holder: NotesViewHolder){
        widget.setOnClickListener {
            onDoSomething(position,holder)
        }
    }

    fun onItemLongClick(widget : ConstraintLayout, context: Context, onDoSomething : () -> Unit, position: Int, holder: NotesViewHolder) {
        widget.setOnLongClickListener {
            onDoSomething()
            true
        }

    }

    interface onItemClickListner{
        fun onNavigate(position: Int, holder: NotesViewHolder)
        fun onShowBottomPopup()
    }
}