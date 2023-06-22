package com.hackathon.readmeandroid.model.network

import com.hackathon.readmeandroid.model.network.dto.request.LoginReqeust
import com.hackathon.readmeandroid.model.network.dto.request.SignupStudentRequest
import com.hackathon.readmeandroid.model.network.dto.response.loginresponse.LoginResponse
import com.hackathon.readmeandroid.model.network.dto.response.signupstudentresponse.SignupStudentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("/user/login")
    fun login(
        @Body loginReqeust: LoginReqeust
    ): Call<LoginResponse>

    @POST("/user/signup/student")
    fun signup(
        @Body signupStudentRequest: SignupStudentRequest
    ): Call<SignupStudentResponse>
}