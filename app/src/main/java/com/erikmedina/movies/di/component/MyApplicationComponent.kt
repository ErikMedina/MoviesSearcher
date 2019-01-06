package com.erikmedina.movies.di.component

import android.content.Context
import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.data.remote.service.ApiRest
import com.erikmedina.movies.di.module.MyApplicationModule
import com.erikmedina.movies.di.qualifier.MyApplicationContext
import com.erikmedina.movies.domain.repository.Repository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MyApplicationModule::class)])
interface MyApplicationComponent {

    @get:MyApplicationContext
    val context: Context

    val myApplication: MyApplication

    val repository: Repository

    val apiRest: ApiRest

    fun inject(myApplication: MyApplication)

}
