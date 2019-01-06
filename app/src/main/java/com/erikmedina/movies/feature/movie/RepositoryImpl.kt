package com.erikmedina.movies.feature.movie

import android.util.Log
import com.erikmedina.movies.core.rest.ApiRest
import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.data.remote.model.Search
import com.erikmedina.movies.data.remote.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The repository will be responsible for transforming the data for the input and output of information.
 */
@Singleton
class RepositoryImpl
@Inject
constructor(private val apiRest: ApiRest) : Repository {

    override fun getContentList(title: String, callback: Repository.Callback<List<Item>>) {
        Log.i(TAG, "[getContentList]")
        val call = apiRest.getContentList(title)
        call.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>) {
                if (response.isSuccessful) {
                    callback.onSuccess(Mapper.mapItems(response.body()))
                }
            }

            override fun onFailure(call: Call<SearchResponse>?, t: Throwable) {
                callback.onError(t)
            }
        })
    }

    override fun getContent(id: String, callback: Repository.Callback<Item>) {
        Log.i(TAG, "[getContent]")
        val call = apiRest.getContent(id)
        call.enqueue(object : Callback<Search> {
            override fun onResponse(call: Call<Search>?, response: Response<Search>) {
                if (response.isSuccessful) {
                    callback.onSuccess(Mapper.mapItem(response.body()))
                }
            }

            override fun onFailure(call: Call<Search>?, t: Throwable) {
                callback.onError(t)
            }
        })
    }

    companion object {
        val TAG = RepositoryImpl::class.java.simpleName.toString()
    }
}
