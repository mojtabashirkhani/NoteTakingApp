package com.slimshady.noteapp.di.builder

import androidx.lifecycle.ViewModel
import com.slimshady.noteapp.di.qualifier.ViewModelKey
import com.slimshady.noteapp.ui.home.HomeViewModel
import com.slimshady.noteapp.ui.note.AddNoteViewModel
import com.slimshady.noteapp.ui.note.ShowNoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
    abstract fun bindShowNoteViewModel(showNoteViewModel: ShowNoteViewModel): ViewModel
    abstract fun bindAddNoteViewModel(addNoteViewModel: AddNoteViewModel): ViewModel

}