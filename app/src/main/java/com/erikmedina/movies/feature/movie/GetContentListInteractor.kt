package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Movie
import com.erikmedina.movies.core.interactor.UseCase

interface GetContentListInteractor : UseCase {

    interface Callback {

        fun onSuccess(movies: List<Movie>)

        fun onError(throwable: Throwable)
    }

    fun run(title: String, callback: Callback)
}
