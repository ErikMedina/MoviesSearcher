package com.erikmedina.movies.core.di.module

import android.content.Context
import com.erikmedina.movies.MyApplication
import com.erikmedina.movies.core.network.ApiRest
import com.erikmedina.movies.core.network.RetrofitFactory
import com.erikmedina.movies.feature.movie.MoviesRepository
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
    fun provideMoviesRepository(moviesRepository: MoviesRepository.Network): MoviesRepository {
        return moviesRepository
    }

    @Singleton
    @Provides
    fun provideApiRest(): ApiRest {
        return RetrofitFactory.apiRest()
    }
}
