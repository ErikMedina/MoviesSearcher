package com.erikmedina.movies.feature.movie

import android.util.Log
import com.erikmedina.movies.core.network.ApiRest
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface MoviesRepository {

    interface Callback<T> {

        fun onSuccess(generic: T)

        fun onError(throwable: Throwable)
    }

    fun getContentList(title: String, callback: Callback<List<Movie>>)

    fun getContent(id: String, callback: Callback<Movie>)

    @Singleton
    class Network
    @Inject
    constructor(private val apiRest: ApiRest) : MoviesRepository {

        override fun getContentList(title: String, callback: MoviesRepository.Callback<List<Movie>>) {
            Log.i(TAG, "[getContentList]")
            val call = apiRest.getContentList(title)
            call.enqueue(object : retrofit2.Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(Mapper.mapMovies(response.body()))
                    }
                }

                override fun onFailure(call: Call<SearchResponse>?, t: Throwable) {
                    callback.onError(t)
                }
            })
        }

        override fun getContent(id: String, callback: MoviesRepository.Callback<Movie>) {
            Log.i(TAG, "[getContent]")
            val call = apiRest.getContent(id)
            call.enqueue(object : retrofit2.Callback<Search> {
                override fun onResponse(call: Call<Search>?, response: Response<Search>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(Mapper.mapMovie(response.body()))
                    }
                }

                override fun onFailure(call: Call<Search>?, t: Throwable) {
                    callback.onError(t)
                }
            })
        }

        companion object {
            val TAG = Network::class.java.simpleName.toString()
        }
    }
}
