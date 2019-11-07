package com.slimshady.noteapp.ui.note

import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Single
import javax.inject.Inject

class ShowNoteViewModel @Inject constructor(var noteRepository: NoteRepository): ViewModel() {

    fun getNoteById(id: Int): Single<Note>{
        return noteRepository.getNoteById(id)
    }

}