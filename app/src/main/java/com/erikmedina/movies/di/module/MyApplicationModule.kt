package com.erikmedina.movies.di.module

import android.content.Context
import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.data.remote.service.ApiRest
import com.erikmedina.movies.data.remote.service.RetrofitFactory
import com.erikmedina.movies.di.qualifier.MyApplicationContext
import com.erikmedina.movies.domain.repository.Repository
import com.erikmedina.movies.domain.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

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
    fun provideRetrofitFactory(): RetrofitFactory {
        return RetrofitFactory
    }

    @Provides
    fun provideRepository(apiRest: ApiRest): Repository {
        return RepositoryImpl(apiRest)
    }

    @Provides
    fun provideApiRest(): ApiRest {
        return RetrofitFactory.createWebService()
    }
}
