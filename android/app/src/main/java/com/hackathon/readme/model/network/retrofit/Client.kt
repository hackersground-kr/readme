package com.hackathon.readme.model.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    const val BASEURL = "0.0.0.0"

    private val loggingInterceptor = LoggingInterceptor()


    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}