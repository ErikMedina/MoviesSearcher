package com.erikmedina.movies.core.di.module

import android.content.Context
import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.core.di.qualifier.MyApplicationContext
import com.erikmedina.movies.core.rest.ApiRest
import com.erikmedina.movies.core.rest.RetrofitFactory
import com.erikmedina.movies.domain.repository.Repository
import com.erikmedina.movies.domain.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyApplicationModule(private val myApplication: MyApplication) {

    @Provides
    @MyApplicationContext
    internal fun provideContext(): Context {
        return myApplication
    }

    @Provides
    internal fun provideMyApplication(): MyApplication {
        return myApplication
    }

    @Provides
    fun provideRepository(apiRest: ApiRest): Repository {
        return RepositoryImpl(apiRest)
    }

    @Singleton
    @Provides
    fun provideApiRest(): ApiRest {
        return RetrofitFactory.apiRest()
    }
}
