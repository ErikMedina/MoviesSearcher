package com.erikmedina.movies.di.component

import com.erikmedina.movies.di.module.MainModule
import com.erikmedina.movies.di.qualifier.PerActivity
import com.erikmedina.movies.presentation.main.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(MyApplicationComponent::class)], modules = [(MainModule::class)])
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}
