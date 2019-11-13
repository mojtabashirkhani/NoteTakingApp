package com.slimshady.noteapp.ui.listener

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.slimshady.noteapp.R
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.ui.main.MainActivity
import javax.inject.Inject


class InteractionsListenerImpl @Inject constructor(private var activity: MainActivity) :  HomeInteractionListener, NoteInteractionListener {

    private val TAG = MainActivity::class.java.simpleName



    override fun homeToAddNote() {
        findNavController(activity, R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note)
    }

    override fun homeToShowNote(note: Note) {
        val args = Bundle()
        args.putSerializable("show_note",note)
        findNavController(activity, R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_show_note, args)    }

    override fun homeToEditNote(id: String) {
        val args = Bundle()
        args.putString("edit_note", id)
        findNavController(activity, R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add_note, args)
    }

    override fun deleteNote(note: Note) {
        /*compositeDisposable.add(viewModel.deleteNote(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "DELETE: deleted successfully")

            }, {t: Throwable? ->
                Log.d(TAG,"DELETE: ${t?.message}")
            }))*/
    }

    override fun noteToHome() {
        findNavController(activity, R.id.nav_host_fragment).navigate(R.id.action_nav_add_note_to_nav_home)
    }

     fun dispose(){
//        compositeDisposable.dispose()
    }

    fun deleteAllNote(){
        /*compositeDisposable.add(viewModel.deleteAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "DELETE: deleted successfully")

            }, {t: Throwable? ->
                Log.d(TAG,"DELETE: ${t?.message}")
            }))*/
    }
}