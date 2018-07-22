package com.erikmedina.article.di.component

import android.content.Context
import com.erikmedina.article.MyApplication
import com.erikmedina.article.data.remote.service.ApiRest
import com.erikmedina.article.di.module.MyApplicationModule
import com.erikmedina.article.di.qualifier.MyApplicationContext
import com.erikmedina.article.domain.repository.Repository
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
