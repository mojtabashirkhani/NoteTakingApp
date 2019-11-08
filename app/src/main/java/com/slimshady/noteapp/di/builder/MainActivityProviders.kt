package com.slimshady.noteapp.di.builder

import com.slimshady.noteapp.ui.home.HomeFragment
import com.slimshady.noteapp.ui.note.AddNoteFragment
import com.slimshady.noteapp.ui.note.ShowNoteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders{

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideShowNoteFragment(): ShowNoteFragment

    @ContributesAndroidInjector
    abstract fun provideAddNoteFragment(): AddNoteFragment

}