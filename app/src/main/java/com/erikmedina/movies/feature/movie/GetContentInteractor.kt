package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.core.interactor.UseCase

interface GetContentInteractor : UseCase {

    interface Callback {

        fun onSuccess(item: Item)

        fun onError(throwable: Throwable)
    }

    fun run(id: String, callback: Callback)
}
