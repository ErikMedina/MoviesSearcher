package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.interactor.UseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

interface GetMovies : UseCase {

    interface Callback {

        fun onSuccess(movies: List<Movie>)

        fun onError(throwable: Throwable)
    }

    fun run(title: String, callback: Callback)

    class Interactor
    @Inject
    constructor(private val moviesRepository: MoviesRepository) : GetMovies {

        private var title = ""
        private lateinit var callback: GetMovies.Callback

        override fun run(title: String, callback: GetMovies.Callback) {
            this.title = title
            this.callback = callback
            execute()
        }

        override fun execute() {
            launch(UI) {
                moviesRepository.getContentList(title, object : MoviesRepository.Callback<List<Movie>> {
                    override fun onSuccess(movies: List<Movie>) {
                        callback.onSuccess(movies)
                    }

                    override fun onError(throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
            }
        }
    }
}
