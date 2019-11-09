package com.slimshady.noteapp.ui.listener

import com.slimshady.noteapp.data.model.Note

interface HomeInteractionListener {
    fun homeToAddNote()
    fun homeToShowNote(note: Note)
    fun homeToEditNote(id: String)
    fun deleteNote(note: Note)
}