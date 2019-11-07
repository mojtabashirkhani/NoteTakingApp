package com.slimshady.noteapp.data.repository

import android.util.Log
import com.slimshady.noteapp.data.db.AppDatabase
import com.slimshady.noteapp.data.model.Note
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NoteRepositoryImpl(private val database: AppDatabase): NoteRepository {

    private val TAG = NoteRepositoryImpl::class.java.simpleName


    override fun insertNotes(note: List<Note>): Disposable =
        Observable
            .fromCallable { database.noteDao().insertNotes(note) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note added: subscribe: $it")
            }

    override fun deleteNote(note: Note): Disposable =
        Observable
            .fromCallable { database.noteDao().deleteNote(note) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note deleted: subscribe: $it")
            }

    override fun deleteAllNote(): Disposable =
        Observable
            .fromCallable { database.noteDao().deleteAllNotes() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note added: subscribe: $it")
            }

    override fun editNote(note: Note): Disposable =
        Observable
            .fromCallable { database.noteDao().editNote(note) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note edited: subscribe: $it")
            }

    override fun getAllNotes(): Disposable =
        Observable
            .fromCallable { database.noteDao().getAllNotes() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note added: subscribe: $it")
            }

    override fun getNoteById(id: Int): Disposable =
        Observable
            .fromCallable { database.noteDao().getNoteById(id) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note added: subscribe: $it")
            }



    override fun insertNote(note: Note): Disposable =
        Observable
            .fromCallable { database.noteDao().insertNote(note) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "note added: subscribe: $it")
            }
}