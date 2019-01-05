package com.erikmedina.article.data.remote.service

import com.erikmedina.article.data.remote.model.ContentResponse
import com.erikmedina.article.data.remote.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The API for all the requests of the application
 */
interface ApiRest {

    companion object {
        const val SEARCH = "s"
        const val MOVIE_ID = "i"
    }

    @GET("./?apikey=4dfc3ce9")
    fun getContentList(@Query(SEARCH) title: String): Call<SearchResponse>

    @GET("./?apikey=4dfc3ce9")
    fun getContent(@Query(MOVIE_ID) id: String): Call<ContentResponse>
}
