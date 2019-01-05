package com.erikmedina.article.domain.interactor

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.domain.interactor.base.Interactor

interface GetContentInteractor : Interactor {

    interface Callback {

        fun onSuccess(item: Item)

        fun onError(throwable: Throwable)
    }

    fun run(id: String, callback: Callback)
}
