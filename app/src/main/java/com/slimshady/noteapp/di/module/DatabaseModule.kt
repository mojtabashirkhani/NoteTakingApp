package com.slimshady.noteapp.di.module

import android.app.Application
import androidx.room.Room
import com.slimshady.noteapp.data.db.AppDatabase
import com.slimshady.noteapp.data.db.NoteDao
import com.slimshady.noteapp.data.repository.NoteRepository
import com.slimshady.noteapp.data.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): NoteDao {
        return appDataBase.noteDao()
    }

    @Provides
    fun provideRepository(database: AppDatabase): NoteRepository {
        return NoteRepositoryImpl(database)
    }

}