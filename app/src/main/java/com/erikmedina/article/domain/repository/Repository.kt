package com.erikmedina.article.domain.repository

import com.erikmedina.article.data.local.model.ItemView

interface Repository {

    interface Callback {

        fun onSuccess(itemViews: List<ItemView>)

        fun onError(throwable: Throwable)
    }

    fun getContentList(callback: Repository.Callback)
}
