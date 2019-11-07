package com.slimshady.noteapp.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel
    : ViewModel(), LifecycleObserver {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}