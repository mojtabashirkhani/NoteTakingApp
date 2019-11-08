package com.slimshady.noteapp.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.slimshady.noteapp.R
import com.slimshady.noteapp.databinding.ActivityMainBinding
import com.slimshady.noteapp.ui.listener.NoteInteractionListener
import com.slimshady.noteapp.ui.listener.HomeInteractionListener
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), HomeInteractionListener, NoteInteractionListener {

    override fun homeToEditNote() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note)
    }

    override fun deleteNote() {

    }


    override fun homeToAddNote() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note)
    }

    override fun homeToShowNote() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_show_note)
    }

    override fun noteToHome() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_add_note_to_nav_home)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :  ActivityMainBinding
                =  DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setSupportActionBar(binding.toolbar)
//        val navController = findNavController(R.id.nav_host_fragment)





    }

  /*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_delete -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
