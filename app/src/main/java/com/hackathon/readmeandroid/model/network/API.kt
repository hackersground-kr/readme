package com.hackathon.readmeandroid.model.network

import com.hackathon.readmeandroid.model.network.dto.request.LoginReqeust
import com.hackathon.readmeandroid.model.network.dto.request.SignupRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("/")
    fun login(
        @Body body: LoginReqeust
    ): Call<Any>
    @POST("/")
    fun signup(
        @Body body: SignupRequest
    ): Call<Any>
}