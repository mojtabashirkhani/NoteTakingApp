package com.slimshady.noteapp.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.data.repository.NoteRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ShowNoteViewModel @Inject constructor(var noteRepository: NoteRepository): ViewModel() {

    fun getNoteById(id: String): LiveData<Note>{
        return noteRepository.getNoteById(id)
            .flatMap { Single.just(it) }
//            .onErrorReturn { Collections.emptyList() }
            .subscribeOn(Schedulers.io())
            .to { LiveDataReactiveStreams.fromPublisher(it.toFlowable()) }
    }

}