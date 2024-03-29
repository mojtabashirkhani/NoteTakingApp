package com.slimshady.noteapp.di.component

import android.app.Application
import com.slimshady.noteapp.core.App
import com.slimshady.noteapp.di.builder.ActivityBuilder
import com.slimshady.noteapp.di.module.CompositeDisposableModule
import com.slimshady.noteapp.di.module.ContextModule
import com.slimshady.noteapp.di.module.DatabaseModule
import com.slimshady.noteapp.di.module.ListenerModule
import com.slimshady.noteapp.ui.listener.InteractionsListenerImpl
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,  ActivityBuilder::class,
    DatabaseModule::class, ContextModule::class, CompositeDisposableModule::class,
    ListenerModule::class])
interface CoreComponent : AndroidInjector<App> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent

        @BindsInstance
        fun listenerModule(listenerModule: ListenerModule): Builder
    }


}