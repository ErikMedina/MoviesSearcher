package com.erikmedina.article.presentation

interface BaseView<T> {

    fun showError(error: String)

    fun showLoading(show: Boolean)
}
