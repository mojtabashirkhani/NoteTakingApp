package com.slimshady.noteapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.slimshady.noteapp.R
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.databinding.ActivityMainBinding
import com.slimshady.noteapp.ui.home.HomeViewModel
import com.slimshady.noteapp.ui.listener.NoteInteractionListener
import com.slimshady.noteapp.ui.listener.HomeInteractionListener
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HomeInteractionListener, NoteInteractionListener {

    private val TAG = MainActivity::class.java.simpleName

    private var compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainActivityViewModel by lazy { ViewModelProviders.of(this,viewModelFactory).get(
        MainActivityViewModel::class.java) }

    override fun deleteNote(note: Note) {

        compositeDisposable.add(viewModel.deleteNote(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "DELETE: deleted successfully")

            }, {t: Throwable? ->
                Log.d(TAG,"DELETE: ${t?.message}")
            }))

    }

    override fun homeToEditNote(id: Int) {
        val args = Bundle()
        args.putInt("edit_note", id)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note, args)
    }


    override fun homeToAddNote() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note)
    }

    override fun homeToShowNote(note: Note) {
        val args = Bundle()
        args.putSerializable("show_note",note)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_show_note, args)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        compositeDisposable.add(viewModel.deleteAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "DELETE: deleted successfully")

            }, {t: Throwable? ->
                Log.d(TAG,"DELETE: ${t?.message}")
            }))

        return when (item.itemId) {
            R.id.action_delete -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }

}
