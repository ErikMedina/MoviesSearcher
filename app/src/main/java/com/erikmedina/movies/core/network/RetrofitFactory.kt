package com.erikmedina.movies.core.network

import com.erikmedina.movies.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val API_KEY_QUERY = "apikey"
    private const val API_KEY = "4dfc3ce9"//Probably we'll retrieve the token from a login request,
    //we will persist this token in the preferences and we'll check there to know if we have already
    //logged in

    fun apiRest(): ApiRest {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiRest::class.java)
    }

    private fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter(API_KEY_QUERY, API_KEY)
                    .build()
            val requestBuilder = original.newBuilder()
                    .url(url)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(interceptor)

        return client.build()
    }
}
