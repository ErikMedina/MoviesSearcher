package com.erikmedina.article.domain.repository

import android.util.Log
import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.data.remote.model.ContentResponse
import com.erikmedina.article.data.remote.model.SearchResponse
import com.erikmedina.article.data.remote.service.ApiRest
import com.erikmedina.article.util.Mapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

/**
 * The repository will be responsible for transforming the data for the input and output of information.
 */
@Singleton
class RepositoryImpl constructor(private val apiRest: ApiRest) : Repository {

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

    override fun getContent(id: Int, callback: Repository.Callback<Item>) {
        Log.i(TAG, "[getContent]")
        val call = apiRest.getContent(id)
        call.enqueue(object : Callback<ContentResponse> {
            override fun onResponse(call: Call<ContentResponse>?, response: Response<ContentResponse>) {
                if (response.isSuccessful) {
                    callback.onSuccess(Mapper.mapItem(response.body()))
                }
            }

            override fun onFailure(call: Call<ContentResponse>?, t: Throwable) {
                callback.onError(t)
            }
        })
    }

    companion object {
        val TAG = RepositoryImpl::class.java.simpleName.toString()
    }
}
