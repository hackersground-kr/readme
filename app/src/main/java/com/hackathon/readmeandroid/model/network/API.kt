package com.hackathon.readmeandroid.model.network

import com.hackathon.readmeandroid.model.network.dto.request.LoginReqeust
import com.hackathon.readmeandroid.model.network.dto.response.loginresponse.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {
    @POST("/user/login")
    fun login(
        @Body loginReqeust: LoginReqeust
    ): Call<LoginResponse>
}