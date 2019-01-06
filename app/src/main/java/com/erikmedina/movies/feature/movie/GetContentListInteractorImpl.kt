package com.erikmedina.movies.feature.movie

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class GetContentListInteractorImpl
@Inject
constructor(private val moviesRepository: MoviesRepository) : GetContentListInteractor {

    private var title = ""
    private lateinit var callback: GetContentListInteractor.Callback

    override fun run(title: String, callback: GetContentListInteractor.Callback) {
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
