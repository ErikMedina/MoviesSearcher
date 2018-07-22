package com.erikmedina.article.domain.repository

import com.erikmedina.article.data.local.model.ItemView

interface Repository {

    interface Callback<T> {

        fun onSuccess(generic: T)

        fun onError(throwable: Throwable)
    }

    fun getContentList(callback: Callback<List<ItemView>>)
}
