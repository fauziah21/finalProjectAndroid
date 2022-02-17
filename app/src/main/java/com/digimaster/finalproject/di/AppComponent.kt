package com.digimaster.finalproject.di

import com.digimaster.finalproject.viewmodel.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectLogin(loginViewModel: LoginViewModel)
}