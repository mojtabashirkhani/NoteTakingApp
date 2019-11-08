package com.slimshady.noteapp.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.slimshady.noteapp.R
import com.slimshady.noteapp.databinding.FragmentShowNoteBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ShowNoteFragment: DaggerFragment() {

    private val TAG: String = ShowNoteFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = ShowNoteFragment::class.java.name
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ShowNoteViewModel by lazy { ViewModelProviders.of(this,viewModelFactory).get(
        ShowNoteViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentShowNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_show_note, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}