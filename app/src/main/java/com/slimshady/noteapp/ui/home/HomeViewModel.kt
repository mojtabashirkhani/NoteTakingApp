package com.slimshady.noteapp.ui.home

import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject


class HomeViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {


    fun getAllNotes(): Flowable<List<Note>> {
        return noteRepository.getAllNotes()
    }

    fun deleteNote(note: Note): Completable {

        return Completable.fromAction {
            noteRepository.deleteNote(note)
        }
    }

    fun deleteAllNotes(): Completable{

        return Completable.fromAction{
            noteRepository.deleteAllNote()
        }
    }

}