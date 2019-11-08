package com.slimshady.noteapp.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
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

    fun getNoteById(id: Int): LiveData<Note> {
        return noteRepository.getNoteById(id)
            .flatMap { Single.just(it) }
//            .onErrorReturn { Collections.emptyList() }
            .subscribeOn(Schedulers.io())
            .to { LiveDataReactiveStreams.fromPublisher(it.toFlowable()) }
    }

}