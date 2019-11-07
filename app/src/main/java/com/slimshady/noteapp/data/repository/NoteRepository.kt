package com.slimshady.noteapp.data.repository

import com.slimshady.noteapp.data.model.Note
import io.reactivex.disposables.Disposable

interface NoteRepository {


    fun insertNote(note: Note): Disposable
    fun insertNotes(note: List<Note>): Disposable
    fun deleteNote(note: Note): Disposable
    fun deleteAllNote(): Disposable
    fun editNote(note: Note): Disposable
    fun getAllNotes(): Disposable
    fun getNoteById(id: Int): Disposable

}