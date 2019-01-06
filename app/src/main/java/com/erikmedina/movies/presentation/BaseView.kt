package com.erikmedina.movies.presentation

interface BaseView<T> {

    fun showError(error: String)

    fun showLoading(show: Boolean)
}
