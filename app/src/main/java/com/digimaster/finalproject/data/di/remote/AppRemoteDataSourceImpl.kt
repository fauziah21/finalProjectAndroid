package com.digimaster.finalproject.data.di.remote

import com.digimaster.finalproject.model.login.LoginResponse
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import com.digimaster.finalproject.service.AppService
import io.reactivex.Single
import javax.inject.Inject

class AppRemoteDataSourceImpl @Inject constructor(private val service:AppService):AppRemoteDataSource {
    override fun postLogin(requestLogin: RequestLogin): Single<LoginResponse> {
        return service.postLogin(requestLogin)
    }
}