package com.slimshady.noteapp.ui.main

import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Completable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(var noteRepository: NoteRepository): ViewModel()  {

    fun deleteAllNotes(): Completable {

        return Completable.fromAction{
            noteRepository.deleteAllNote()
        }
    }

    fun deleteNote(note: Note): Completable {

        return Completable.fromAction {
            noteRepository.deleteNote(note)
        }
    }



}