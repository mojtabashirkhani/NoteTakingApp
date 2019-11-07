package com.slimshady.noteapp.di.builder

import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.di.qualifier.ViewModelKey
import com.slimshady.noteapp.ui.home.HomeViewModel
import com.slimshady.noteapp.ui.note.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
    abstract fun bindNoteViewModel(noteViewModel: NoteViewModel): ViewModel

}