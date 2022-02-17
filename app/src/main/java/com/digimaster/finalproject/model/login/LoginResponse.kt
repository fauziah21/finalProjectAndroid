package com.digimaster.finalproject.model.login

data class LoginResponse(
    val code: Int,
    val `data`: Data,
    val status: String
)