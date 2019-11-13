package com.slimshady.noteapp.di.module

import com.slimshady.noteapp.ui.listener.InteractionsListenerImpl
import com.slimshady.noteapp.ui.main.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ListenerModule {


    @Provides
    @Singleton
    fun provideMainActivity(): MainActivity{
        return MainActivity()
    }

    @Provides
    @Singleton
    fun provideInteractionListeners(activity: MainActivity): InteractionsListenerImpl{
        return InteractionsListenerImpl(activity)
    }

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