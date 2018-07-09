package com.example.mvp.features.login.di

import com.example.mvp.di.AppComponent
import com.example.mvp.features.login.presentation.LoginActivity
import dagger.Component

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
@LoginFeatureScoped
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(LoginDataModule::class, LoginViewModel::class))
interface LoginComponent {

    fun inject(activity: LoginActivity)
}
