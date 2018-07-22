package com.erikmedina.article.domain.interactor

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.domain.interactor.base.Interactor

interface GetContentListInteractor : Interactor {

    interface Callback {

        fun onSuccess(items: List<Item>)

        fun onError(throwable: Throwable)
    }

    fun run(callback: Callback)
}
