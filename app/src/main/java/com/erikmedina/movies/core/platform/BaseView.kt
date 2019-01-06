package com.erikmedina.movies.core.platform

interface BaseView {

    fun showError(error: String)

    fun showLoading(show: Boolean)
}
