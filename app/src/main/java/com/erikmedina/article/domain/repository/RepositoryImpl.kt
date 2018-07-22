package com.erikmedina.article.domain.repository

import android.util.Log
import com.erikmedina.article.data.remote.model.ContentListResponse
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

    override fun getContentList(callback: Repository.Callback) {
        Log.i(TAG, "[getContentList]")
        val call = apiRest.getContentList()
        call.enqueue(object : Callback<ContentListResponse> {
            override fun onResponse(call: Call<ContentListResponse>?, response: Response<ContentListResponse>) {
                if (response.isSuccessful) {
                    callback.onSuccess(Mapper.map(response.body()))
                }
            }

            override fun onFailure(call: Call<ContentListResponse>?, t: Throwable) {
                callback.onError(t)
            }
        })
    }

    companion object {
        val TAG = RepositoryImpl::class.java.simpleName.toString()
    }
}
