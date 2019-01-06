package com.erikmedina.movies.data.remote.service

import com.erikmedina.movies.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * We only need one instance of Retrofit so we use Kotlin's Object to declare this
 * class as a Singleton
 */
object RetrofitFactory {

    fun createWebService(): ApiRest {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiRest::class.java)
    }
}
