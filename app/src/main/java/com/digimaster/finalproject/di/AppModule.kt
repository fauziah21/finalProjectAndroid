package com.digimaster.finalproject.di

import com.digimaster.finalproject.data.di.remote.AppRemoteDataSource
import com.digimaster.finalproject.data.di.remote.AppRemoteDataSourceImpl
import com.digimaster.finalproject.repository.AppRepository
import com.digimaster.finalproject.repository.AppRepositoryImpl
import com.digimaster.finalproject.service.AppRetrofit
import com.digimaster.finalproject.service.AppService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRepository(appRemoteDataSource: AppRemoteDataSource): AppRepository {
        return AppRepositoryImpl(appRemoteDataSource)
    }
    @Provides
    @Singleton
    fun provideRemoteDataSource(appService: AppService):AppRemoteDataSource{
        return AppRemoteDataSourceImpl(appService)
    }
    @Provides
    @Singleton
    fun provideAppService():AppService{
        return AppRetrofit.appService
    }
}