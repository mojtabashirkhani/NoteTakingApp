package com.slimshady.noteapp.core

import androidx.fragment.app.FragmentManager
import com.slimshady.noteapp.ui.home.HomeFragment
import com.slimshady.noteapp.ui.note.AddNoteFragment
import com.slimshady.noteapp.ui.note.ShowNoteFragment

object FragmentFactory {

    fun getHomeFragment(supportFragmentManager: FragmentManager): HomeFragment {
        var fragment = supportFragmentManager.findFragmentByTag(HomeFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = HomeFragment()
        }
        return fragment as HomeFragment
    }

    fun getShowNoteFragment(supportFragmentManager: FragmentManager): ShowNoteFragment{
        var fragment = supportFragmentManager.findFragmentByTag(ShowNoteFragment.FRAGMENT_NAME)
        if (fragment == null){
            fragment = ShowNoteFragment()
        }
        return fragment as ShowNoteFragment
    }

    fun getAddNoteFragment(supportFragmentManager: FragmentManager): AddNoteFragment{
        var fragment = supportFragmentManager.findFragmentByTag(AddNoteFragment.FRAGMENT_NAME)
        if (fragment == null){
            fragment = AddNoteFragment()
        }
        return fragment as AddNoteFragment
    }

}