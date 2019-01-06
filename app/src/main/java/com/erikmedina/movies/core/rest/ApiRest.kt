package com.erikmedina.movies.core.rest

import com.erikmedina.movies.data.remote.model.Search
import com.erikmedina.movies.data.remote.model.SearchResponse
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

    @GET(".")
    fun getContentList(@Query(SEARCH) title: String): Call<SearchResponse>

    @GET(".")
    fun getContent(@Query(MOVIE_ID) id: String): Call<Search>
}
