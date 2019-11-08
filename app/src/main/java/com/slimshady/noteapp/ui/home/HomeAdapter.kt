package com.slimshady.noteapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.databinding.ItemNoteBinding
import com.slimshady.noteapp.ui.base.DataBindingViewHolder
import com.slimshady.noteapp.BR.item
import com.slimshady.noteapp.ui.listener.HomeInteractionListener
import kotlinx.android.synthetic.main.item_note.view.*

class HomeAdapter(private val notes: MutableList<Note>, private val homeToAddNoteListener: HomeInteractionListener?,
                  private val homeToShowNoteListener: HomeInteractionListener?, private val deleteNote: HomeInteractionListener?)
    : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding  = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(notes[position])

    }

    fun add(list: MutableList<Note>) {
        notes.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        notes.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(dataBinding: ViewDataBinding): DataBindingViewHolder<Note>(dataBinding){
        override fun onBind(t: Note): Unit = with(t) {
            dataBinding.setVariable(item,t)
        }

        init {


            dataBinding.root.img_delete.setOnClickListener {
                deleteNote?.deleteNote(notes[adapterPosition])
            }

            dataBinding.root.img_edit.setOnClickListener {
                notes[adapterPosition].id?.let { it1 -> homeToAddNoteListener?.homeToEditNote(it1) }

            }

            dataBinding.root.setOnClickListener {
                homeToShowNoteListener?.
                    homeToShowNote(notes[adapterPosition])

            }
        }

    }
}