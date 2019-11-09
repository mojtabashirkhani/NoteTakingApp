package com.slimshady.noteapp.data.repository

import androidx.lifecycle.LiveData
import com.slimshady.noteapp.data.model.Note
import io.reactivex.Flowable
import io.reactivex.Single

interface NoteRepository {


    fun insertNote(note: Note)
    fun deleteNote(note: Note)
    fun deleteAllNote()
    fun editNote(note: Note)
    fun getAllNotes(): Flowable<List<Note>>
    fun getNoteById(id: String):  Single<Note>
    fun getAllNotesTest(): LiveData<MutableList<Note>>

}