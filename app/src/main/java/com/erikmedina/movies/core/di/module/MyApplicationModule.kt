package com.erikmedina.movies.core.di.module

import android.content.Context
import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.core.rest.ApiRest
import com.erikmedina.movies.core.rest.RetrofitFactory
import com.erikmedina.movies.domain.repository.Repository
import com.erikmedina.movies.domain.repository.RepositoryImpl
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
    fun provideRepository(apiRest: ApiRest): Repository {
        return RepositoryImpl(apiRest)
    }

    @Singleton
    @Provides
    fun provideApiRest(): ApiRest {
        return RetrofitFactory.apiRest()
    }
}
