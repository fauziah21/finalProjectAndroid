package com.digimaster.finalproject.service

import com.digimaster.finalproject.model.login.LoginResponse
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AppService {
    @POST("api/v1/user/login")
    fun postLogin(@Body requestLogin: RequestLogin): Single<LoginResponse>
}