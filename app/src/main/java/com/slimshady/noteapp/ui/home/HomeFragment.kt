package com.slimshady.noteapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.slimshady.noteapp.R
import com.slimshady.noteapp.data.model.Note
import com.slimshady.noteapp.databinding.FragmentHomeBinding
import com.slimshady.noteapp.ui.listener.HomeInteractionListener
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : DaggerFragment(){
    private val TAG: String = HomeFragment::class.java.simpleName

    private var homeToAddNoteListener: HomeInteractionListener? = null
    private var homeToShowNoteListener: HomeInteractionListener? = null

    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy { ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java) }
    val adapter : HomeAdapter by lazy { HomeAdapter(arrayListOf()) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentHomeBinding = inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
//            homeInteractionListener = HomeInteractionListener()
            homeToAddNoteListener?.homeToAddNote()

        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {

            getAllNotes().observe(this@HomeFragment, Observer {
                initView(it)
            })


        }
    }


      private fun initView(it: MutableList<Note>) {
          recycler_home.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
          recycler_home.adapter = adapter

          if (it.isNotEmpty()) {
              adapter.clear()
              adapter.add(it)

          } else {
              Toast.makeText(context, context?.getString(R.string.empty_list), android.widget.Toast.LENGTH_LONG).show()
          }
      }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is HomeInteractionListener ){
            homeToAddNoteListener = context
            homeToShowNoteListener = context


        }  else {
            throw RuntimeException(context.toString() + " must implement HomeInteraction") as Throwable

        }
    }

    override fun onDetach() {
        super.onDetach()
        homeToAddNoteListener = null
        homeToShowNoteListener = null

    }

}