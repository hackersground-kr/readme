package com.hackathon.readmeandroid.model.network.dto.request

data class SignupEnterpriseRequest(
    val email: String,
    val employee: Int,
    val income: Int,
    val location: String,
    val name: String,
    val password: String
)