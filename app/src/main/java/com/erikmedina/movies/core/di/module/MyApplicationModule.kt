package com.erikmedina.movies.core.di.module

import android.content.Context
import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.core.rest.ApiRest
import com.erikmedina.movies.core.rest.RetrofitFactory
import com.erikmedina.movies.feature.movie.Repository
import com.erikmedina.movies.feature.movie.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyApplicationModule {

    @Provides
    internal fun provideContext(myApplication: MyApplication): Context {
        return myApplication.applicationContext
    }

    @Provides
    fun provideRepository(repository: RepositoryImpl): Repository {
        return repository
    }

    @Singleton
    @Provides
    fun provideApiRest(): ApiRest {
        return RetrofitFactory.apiRest()
    }
}
