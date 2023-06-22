package com.hackathon.readmeandroid.model.network.dto.request

data class SignupRequest(
    val email: String,
    val name: String,
    val password: String,
    val schoolname: String
)