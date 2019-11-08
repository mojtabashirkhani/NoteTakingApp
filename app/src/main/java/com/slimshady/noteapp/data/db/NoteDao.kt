package com.slimshady.noteapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.slimshady.noteapp.data.model.Note
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NoteDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)


    @Query("SELECT * FROM note")
    fun getAllNotes(): Flowable<List<Note>>

    @Query("SELECT * FROM note")
    fun getAllNotesTest(): LiveData<MutableList<Note>>

    @Query("SELECT * FROM note WHERE id = (:id)")
    fun getNoteById(id: Int): Single<Note>

    @Update
    fun editNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("Delete FROM note")
    fun deleteAllNotes()


}