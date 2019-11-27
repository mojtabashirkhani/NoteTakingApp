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




    fun getAllNotes(): LiveData<MutableList<Note>> {
        return noteRepository.getAllNotes()
            .onErrorReturn { Collections.emptyList() }
            .subscribeOn(Schedulers.io())
            .to { LiveDataReactiveStreams.fromPublisher(it) }
    }







}