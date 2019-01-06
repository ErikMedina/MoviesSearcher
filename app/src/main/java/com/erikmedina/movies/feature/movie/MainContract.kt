package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Movie
import com.erikmedina.movies.core.platform.BasePresenter
import com.erikmedina.movies.core.platform.BaseView

/**
 * This interface specifies the contract between the view and the presenter.
 */

interface MainContract {

    interface View : BaseView<Presenter> {

        fun setItemViews(movies: List<Movie>)

        fun startItemDetailActivity(movie: Movie)
    }

    interface Presenter : BasePresenter<View> {

        fun getContentList(title: String)

        fun onItemSelected(id: String)
    }
}
