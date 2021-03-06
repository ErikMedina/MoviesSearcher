package com.erikmedina.movies.core.di.module

import com.erikmedina.movies.feature.movie.GetMovieDetail
import com.erikmedina.movies.feature.movie.GetMovies
import com.erikmedina.movies.feature.movie.MainContract
import com.erikmedina.movies.feature.movie.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providePresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }

    @Provides
    fun provideGetMoviesInteractor(interactor: GetMovies.Interactor): GetMovies {
        return interactor
    }

    @Provides
    fun provideGetMovieDetailInteractor(interactor: GetMovieDetail.Interactor): GetMovieDetail {
        return interactor
    }
}
