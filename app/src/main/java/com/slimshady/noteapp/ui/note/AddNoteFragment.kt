package com.slimshady.noteapp.ui.note

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.slimshady.noteapp.R
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.databinding.FragmentAddNoteBinding
import com.slimshady.noteapp.ui.home.HomeFragment
import com.slimshady.noteapp.ui.listener.NoteInteractionListener
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_add_note.*
import javax.inject.Inject


class AddNoteFragment: DaggerFragment() {

    private val TAG: String = AddNoteFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = AddNoteFragment::class.java.name
    }

    private var noteInteractionListener: NoteInteractionListener? = null
    private var compositeDisposable = CompositeDisposable()


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: AddNoteViewModel by lazy { ViewModelProviders.of(this,viewModelFactory).get(
        AddNoteViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentAddNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)
        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener {

           compositeDisposable.add( viewModel.insertNote(Note(0,edt_title.text.toString(), edt_description.text.toString()))
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread()).subscribe ({
                   Log.d(TAG,"INSERT: item inserted in table")
               }, { throwable ->
                   Log.e(TAG,"Error: INSERT "+throwable.message)
               }
            ))
            noteInteractionListener?.noteToHome()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is NoteInteractionListener){
            noteInteractionListener = context

        }
    }

    override fun onDetach() {
        super.onDetach()
        noteInteractionListener = null
        compositeDisposable.dispose()
    }


}