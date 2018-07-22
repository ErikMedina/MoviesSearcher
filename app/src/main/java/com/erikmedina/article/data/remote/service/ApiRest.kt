package com.erikmedina.article.data.remote.service

import com.erikmedina.article.data.remote.model.ContentListResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * The API for all the requests of the application
 */
interface ApiRest {

    @GET("test/native/contentList.json")
    fun getContentList(): Call<ContentListResponse>
}
