package com.example.mvp.features.login.di

import com.example.mvp.features.login.domain.LoginUseCase
import com.example.mvp.features.login.presentation.presenter.LoginContract
import com.example.mvp.features.login.presentation.presenter.LoginPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Iliya Gogolev on 12/18/17.
 */
@Module
class LoginViewModel {

    @Provides
    fun provideLoginPresenter(useCase: LoginUseCase): LoginContract.Presenter = LoginPresenter(useCase)
}
