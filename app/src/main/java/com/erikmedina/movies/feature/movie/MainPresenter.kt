package com.erikmedina.movies.feature.movie

import android.content.Context
import com.erikmedina.movies.R
import javax.inject.Inject

class MainPresenter
@Inject
constructor(
        private val context: Context,
        private val getMovies: GetMovies,
        private val getMovieDetail: GetMovieDetail
) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

    override fun getContentList(title: String) {
        view?.showLoading(true)
        getMovies.run(title, object : GetMovies.Callback {
            override fun onSuccess(movies: List<Movie>) {
                view?.setItemViews(movies)
                view?.showLoading(false)
            }

            override fun onError(throwable: Throwable) {
                //If we create an ErrorManager, depends of the type of error we can show different messages to
                //the user. Now we show the same message.
                // Also if we inject a context, we can retrieve string resources and avoid text hardcoding
                view?.showError(context.getString(R.string.error_network))
                view?.showLoading(false)
            }
        })
    }

    override fun onItemSelected(id: String) {
        view?.showLoading(true)
        getMovieDetail.run(id, object : GetMovieDetail.Callback {
            override fun onSuccess(movie: Movie) {
                view?.showLoading(false)
                view?.startItemDetailActivity(movie)
            }

            override fun onError(throwable: Throwable) {
                view?.showError(context.getString(R.string.error_network))
                view?.showLoading(false)
            }
        })
    }

    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }
}
