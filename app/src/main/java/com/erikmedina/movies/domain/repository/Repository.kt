package com.erikmedina.movies.domain.repository

import com.erikmedina.movies.data.local.model.Item

interface Repository {

    interface Callback<T> {

        fun onSuccess(generic: T)

        fun onError(throwable: Throwable)
    }

    fun getContentList(title: String, callback: Callback<List<Item>>)

    fun getContent(id: String, callback: Callback<Item>)
}
