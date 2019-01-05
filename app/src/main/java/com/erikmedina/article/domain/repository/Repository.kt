package com.erikmedina.article.domain.repository

import com.erikmedina.article.data.local.model.Item

interface Repository {

    interface Callback<T> {

        fun onSuccess(generic: T)

        fun onError(throwable: Throwable)
    }

    fun getContentList(title: String, callback: Callback<List<Item>>)

    fun getContent(id: Int, callback: Callback<Item>)
}
