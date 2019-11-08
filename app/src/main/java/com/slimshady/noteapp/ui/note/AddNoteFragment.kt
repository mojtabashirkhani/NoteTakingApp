package com.slimshady.noteapp.ui.note

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.slimshady.noteapp.R
import com.slimshady.noteapp.databinding.FragmentAddNoteBinding
import com.slimshady.noteapp.databinding.FragmentHomeBinding
import com.slimshady.noteapp.ui.home.HomeFragment
import com.slimshady.noteapp.ui.home.HomeViewModel
import com.slimshady.noteapp.ui.listener.NoteInteractionListener
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AddNoteFragment: DaggerFragment() {

    private val TAG: String = HomeFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = AddNoteFragment::class.java.name
    }

    private var noteInteractionListener: NoteInteractionListener? = null

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
            noteInteractionListener?.noteToHome()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(viewModel) {


        }
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
    }


}