package com.erikmedina.article.domain.interactor

import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.domain.interactor.base.Interactor

interface GetContentListInteractor : Interactor {

    interface Callback {

        fun onSuccess(itemViews: List<ItemView>)

        fun onError(throwable: Throwable)
    }

    fun run(callback: Callback)
}
