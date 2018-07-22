package com.erikmedina.article.di.component

import com.erikmedina.article.di.module.MainModule
import com.erikmedina.article.di.qualifier.PerActivity
import com.erikmedina.article.presentation.main.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(MyApplicationComponent::class)], modules = [(MainModule::class)])
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}
