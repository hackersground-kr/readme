package com.hackathon.readmeandroid.model.network.dto.request

data class SignupSchoolRequest(
    val email: String,
    val location: String,
    val name: String,
    val password: String,
    val school_type: String,
    val student: Int
)