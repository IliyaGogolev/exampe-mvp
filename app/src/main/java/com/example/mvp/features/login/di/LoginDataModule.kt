package com.example.mvp.features.login.di

import com.example.mvp.features.login.net.LoginAPIService
import com.example.mvp.features.login.domain.LoginUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Iliya Gogolev on 12/20/17.
 */

@Module
class LoginDataModule {

    @Provides
    fun provideLoginUseCase(apiService: LoginAPIService): LoginUseCase = LoginUseCase(apiService)

    @Provides
    @LoginFeatureScoped
    fun provideLoginAPIService(retrofit: Retrofit): LoginAPIService {
        return retrofit.create(LoginAPIService::class.java)
    }
}