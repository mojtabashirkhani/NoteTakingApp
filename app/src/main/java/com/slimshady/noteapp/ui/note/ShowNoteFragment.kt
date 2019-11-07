package com.slimshady.noteapp.ui.note

import com.slimshady.noteapp.ui.home.HomeFragment
import dagger.android.support.DaggerFragment

class ShowNoteFragment: DaggerFragment() {

    private val TAG: String = HomeFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = ShowNoteFragment::class.java.name
    }

}