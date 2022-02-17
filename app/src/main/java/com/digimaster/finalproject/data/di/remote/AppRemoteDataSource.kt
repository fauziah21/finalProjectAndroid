package com.digimaster.finalproject.data.di.remote

import com.digimaster.finalproject.model.login.LoginResponse
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import io.reactivex.Single

interface AppRemoteDataSource {
    fun postLogin (requestLogin: RequestLogin):Single<LoginResponse>
}