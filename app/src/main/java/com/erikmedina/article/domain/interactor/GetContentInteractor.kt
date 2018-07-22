package com.erikmedina.article.domain.interactor

import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.domain.interactor.base.Interactor

interface GetContentInteractor : Interactor {

    interface Callback {

        fun onSuccess(itemView: ItemView)

        fun onError(throwable: Throwable)
    }

    fun run(id: Int, callback: Callback)
}
