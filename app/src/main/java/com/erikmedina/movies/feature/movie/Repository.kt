package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Movie

interface Repository {

    interface Callback<T> {

        fun onSuccess(generic: T)

        fun onError(throwable: Throwable)
    }

    fun getContentList(title: String, callback: Callback<List<Movie>>)

    fun getContent(id: String, callback: Callback<Movie>)
}
