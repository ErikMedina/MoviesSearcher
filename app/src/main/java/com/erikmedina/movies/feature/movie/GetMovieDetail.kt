package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.extension.unknown
import com.erikmedina.movies.core.interactor.UseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

interface GetMovieDetail : UseCase {

    interface Callback {

        fun onSuccess(movie: Movie)

        fun onError(throwable: Throwable)
    }

    fun run(id: kotlin.String, callback: Callback)

    class Interactor
    @Inject
    constructor(private val moviesRepository: MoviesRepository) : GetMovieDetail {

        private lateinit var callback: GetMovieDetail.Callback
        private var id = String.unknown()

        override fun run(id: kotlin.String, callback: GetMovieDetail.Callback) {
            this.callback = callback
            this.id = id
            execute()
        }

        override fun execute() {
            launch(UI) {
                moviesRepository.getContent(id, object : MoviesRepository.Callback<Movie> {
                    override fun onSuccess(movie: Movie) {
                        callback.onSuccess(movie)
                    }

                    override fun onError(throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
            }
        }
    }
}
