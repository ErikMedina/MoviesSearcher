package com.erikmedina.movies.core.platform

interface BaseView<T> {

    fun showError(error: String)

    fun showLoading(show: Boolean)
}
