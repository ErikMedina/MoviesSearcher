package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.core.interactor.UseCase

interface GetContentListInteractor : UseCase {

    interface Callback {

        fun onSuccess(items: List<Item>)

        fun onError(throwable: Throwable)
    }

    fun run(title: String, callback: Callback)
}
