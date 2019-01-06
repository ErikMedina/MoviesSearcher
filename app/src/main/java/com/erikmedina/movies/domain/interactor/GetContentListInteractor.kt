package com.erikmedina.movies.domain.interactor

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.domain.interactor.base.Interactor

interface GetContentListInteractor : Interactor {

    interface Callback {

        fun onSuccess(items: List<Item>)

        fun onError(throwable: Throwable)
    }

    fun run(title: String, callback: Callback)
}
