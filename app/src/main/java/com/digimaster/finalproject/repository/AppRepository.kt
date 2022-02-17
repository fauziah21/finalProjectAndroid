package com.digimaster.finalproject.repository

import com.digimaster.finalproject.model.login.LoginResponse
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import io.reactivex.Single

interface AppRepository {
    fun postLogin (requestLogin: RequestLogin): Single<LoginResponse>
}