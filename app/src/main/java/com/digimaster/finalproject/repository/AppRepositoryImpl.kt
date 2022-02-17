package com.digimaster.finalproject.repository

import com.digimaster.finalproject.data.di.remote.AppRemoteDataSource
import com.digimaster.finalproject.model.login.LoginResponse
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import io.reactivex.Single
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val remoteDataSource: AppRemoteDataSource):AppRepository{
    override fun postLogin(requestLogin: RequestLogin): Single<LoginResponse> {
        return remoteDataSource.postLogin(requestLogin)
    }
}