package com.erikmedina.movies.domain.interactor

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.domain.interactor.base.Interactor

interface GetContentInteractor : Interactor {

    interface Callback {

        fun onSuccess(item: Item)

        fun onError(throwable: Throwable)
    }

    fun run(id: String, callback: Callback)
}
