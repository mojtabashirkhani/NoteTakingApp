package com.slimshady.noteapp.core

import com.slimshady.noteapp.di.component.DaggerCoreComponent
import com.slimshady.noteapp.di.module.ListenerModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCoreComponent
            .builder()
            .application(this)
            .listenerModule(ListenerModule())
            .build()
    }

}