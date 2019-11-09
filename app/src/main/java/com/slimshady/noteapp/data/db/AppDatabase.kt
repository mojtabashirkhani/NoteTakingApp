package com.slimshady.noteapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slimshady.noteapp.data.model.Note

@Database(entities = [Note::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "note.db"
        const val VERSION = 2
    }
    abstract fun noteDao(): NoteDao
}