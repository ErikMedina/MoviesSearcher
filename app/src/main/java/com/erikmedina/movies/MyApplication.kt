package com.erikmedina.movies

import android.app.Application
import android.content.Context
import com.erikmedina.movies.core.di.component.DaggerMyApplicationComponent
import com.erikmedina.movies.core.di.component.MyApplicationComponent
import com.erikmedina.movies.core.di.module.MyApplicationModule

class MyApplication : Application() {

    private val applicationComponent by lazy {
        DaggerMyApplicationComponent
                .builder()
                .myApplicationModule(MyApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }

    fun getComponent(): MyApplicationComponent {
        return applicationComponent
    }

    companion object {
        fun get(context: Context): MyApplication = context.applicationContext as MyApplication
    }
}
