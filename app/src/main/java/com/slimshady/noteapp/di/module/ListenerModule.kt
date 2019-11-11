package com.slimshady.noteapp.di.module

import com.slimshady.noteapp.ui.listener.HomeInteractionListener
import com.slimshady.noteapp.ui.listener.NoteInteractionListener
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ListenerModule(private val homeInteractionListener: HomeInteractionListener?) {



/*    @Provides
    @Singleton
    fun provideHomeListener(): HomeInteractionListener?{
        return homeInteractionListener
    }*/

   /* @Provides
    @Singleton
    fun provideNoteListener(noteInteractionListener: NoteInteractionListener): NoteInteractionListener{
        return this.provideNoteListener(noteInteractionListener)
    }*/

}