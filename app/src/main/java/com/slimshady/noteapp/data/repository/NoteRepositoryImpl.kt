package com.slimshady.noteapp.data.repository

import androidx.lifecycle.LiveData
import com.slimshady.noteapp.data.db.AppDatabase
import com.slimshady.noteapp.data.model.Note
import io.reactivex.Flowable
import io.reactivex.Single

class NoteRepositoryImpl(private val database: AppDatabase): NoteRepository {

    override fun getAllNotesTest(): LiveData<MutableList<Note>> {
       return database.noteDao().getAllNotesTest()
    }

    private val TAG = NoteRepositoryImpl::class.java.simpleName



    override fun deleteNote(note: Note) {
        database.noteDao().deleteNote(note)
    }

    override fun deleteAllNote() {
        database.noteDao().deleteAllNotes()
    }

    override fun editNote(note: Note) {
        return database.noteDao().editNote(note)

    }


    override fun getAllNotes(): Flowable<List<Note>> {
        return database.noteDao().getAllNotes()
    }


    override fun getNoteById(id: String): Single<Note>{
        return database.noteDao().getNoteById(id)
    }


    override fun insertNote(note: Note){
        database.noteDao().insertNote(note)
    }
}