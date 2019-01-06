package com.erikmedina.movies.core.di.component

import com.erikmedina.movies.core.di.module.MainModule
import com.erikmedina.movies.core.di.qualifier.PerActivity
import com.erikmedina.movies.presentation.main.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(MyApplicationComponent::class)], modules = [(MainModule::class)])
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}
