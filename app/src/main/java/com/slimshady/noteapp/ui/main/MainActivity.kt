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
import com.slimshady.noteapp.ui.listener.HomeInteractionListener
import com.slimshady.noteapp.ui.listener.InteractionsListenerImpl
import com.slimshady.noteapp.ui.listener.NoteInteractionListener
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity @Inject constructor(): DaggerAppCompatActivity(), HomeInteractionListener, NoteInteractionListener {

    private val TAG = MainActivity::class.java.simpleName

   /* @Inject
    lateinit var interactionsListenerImpl: InteractionsListenerImpl*/

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainActivityViewModel by lazy { ViewModelProviders.of(this,viewModelFactory).get(
        MainActivityViewModel::class.java) }

    private val interactionsListenerImpl: InteractionsListenerImpl = InteractionsListenerImpl(this)



    override fun deleteNote(note: Note) {

        compositeDisposable.add(viewModel.deleteNote(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "DELETE: deleted successfully")

            }, {t: Throwable? ->
                Log.d(TAG,"DELETE: ${t?.message}")
            }))
//        interactionListener.deleteNote(note)

    }

    override fun homeToEditNote(id: String) {
        /*val args = Bundle()
        args.putString("edit_note", id)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note, args)*/
        interactionsListenerImpl.homeToEditNote(id)
    }


    override fun homeToAddNote() {
//        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note)
        interactionsListenerImpl.homeToAddNote()
    }

    override fun homeToShowNote(note: Note) {
        /*val args = Bundle()
        args.putSerializable("show_note",note)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_show_note, args)*/
        interactionsListenerImpl.homeToShowNote(note)
    }

    override fun noteToHome() {
        interactionsListenerImpl.noteToHome()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :  ActivityMainBinding
                =  DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setSupportActionBar(binding.toolbar)
//        val navController = findNavController(R.id.nav_host_fragment)


//        navigation.homeToAddNote()




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
//        interactionListener.deleteAllNote()

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
