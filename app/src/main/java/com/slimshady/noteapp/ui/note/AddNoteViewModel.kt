package com.slimshady.noteapp.ui.note

import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Completable
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(var noteRepository: NoteRepository): ViewModel() {


    fun insertNote(note: Note): Completable{
        return Completable.fromAction{
            noteRepository.insertNote(note)
        }
    }

    fun editNote(note: Note): Completable{
        return Completable.fromAction{
            noteRepository.editNote(note)

        }
    }

}