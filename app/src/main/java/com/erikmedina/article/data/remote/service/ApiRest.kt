package com.erikmedina.article.data.remote.service

import com.erikmedina.article.data.remote.model.SearchResponse
import com.erikmedina.article.data.remote.model.ContentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * The API for all the requests of the application
 */
interface ApiRest {

    @GET("test/native/contentList.json")
    fun getContentList(): Call<SearchResponse>

    @GET("test/native/content/{id}.json")
    fun getContent(@Path("id") id: Int): Call<ContentResponse>
}
