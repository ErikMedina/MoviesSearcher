package com.erikmedina.movies.core.di.component

import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.core.di.module.BuildersModule
import com.erikmedina.movies.core.di.module.MyApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, MyApplicationModule::class, BuildersModule::class])
interface MyApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): MyApplicationComponent
    }

    fun inject(myApplication: MyApplication)
}
