package com.slimshady.noteapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class HomeViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {

/*    private val getAllNotes = MutableLiveData<MutableList<Note>>().apply {
        value = getAllNotes().
    }*/

    fun getAllNotes(): LiveData<MutableList<Note>> {
        return noteRepository.getAllNotes()
            .flatMap { Flowable.fromIterable(it) }
            .toList() //Debugger does not enter here
            .toFlowable()
            .onErrorReturn { Collections.emptyList() }
            .subscribeOn(Schedulers.io())
            .to { LiveDataReactiveStreams.fromPublisher(it) }
    }

    fun deleteNote(note: Note): Completable {

        return Completable.fromAction {
            noteRepository.deleteNote(note)
        }
    }



}