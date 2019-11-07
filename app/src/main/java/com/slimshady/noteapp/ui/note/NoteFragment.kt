package com.slimshady.noteapp.ui.note

import com.slimshady.noteapp.ui.home.HomeFragment
import dagger.android.support.DaggerFragment

class NoteFragment: DaggerFragment() {

    private val TAG: String = HomeFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }

}