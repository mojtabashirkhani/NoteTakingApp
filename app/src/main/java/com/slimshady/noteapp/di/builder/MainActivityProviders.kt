package com.slimshady.noteapp.di.builder

import com.slimshady.noteapp.ui.home.HomeFragment
import com.slimshady.noteapp.ui.note.NoteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders{
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
    abstract fun provideNoteFragment(): NoteFragment

}