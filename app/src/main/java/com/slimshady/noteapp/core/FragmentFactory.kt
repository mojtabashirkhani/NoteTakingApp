package com.slimshady.noteapp.core

import androidx.fragment.app.FragmentManager
import com.slimshady.noteapp.ui.home.HomeFragment
import com.slimshady.noteapp.ui.note.NoteFragment

object FragmentFactory {

    fun getHomeFragment(supportFragmentManager: FragmentManager): HomeFragment {
        var fragment = supportFragmentManager.findFragmentByTag(HomeFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = HomeFragment()
        }
        return fragment as HomeFragment
    }

    fun getNoteFragment(supportFragmentManager: FragmentManager): NoteFragment{
        var fragment = supportFragmentManager.findFragmentByTag(NoteFragment.FRAGMENT_NAME)
        if (fragment == null){
            fragment = NoteFragment()
        }
        return fragment as NoteFragment
    }

}