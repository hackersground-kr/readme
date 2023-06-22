package com.hackathon.readmeandroid.model.network.dto.request

data class SignupStudentRequest(
    val birth: String,
    val email: String,
    val grade: String,
    val location: String,
    val name: String,
    val password: String
)