package com.erikmedina.movies.core.network

import com.erikmedina.movies.feature.movie.Search
import com.erikmedina.movies.feature.movie.SearchResponse
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
