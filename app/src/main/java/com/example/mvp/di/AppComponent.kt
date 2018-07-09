package com.example.mvp.di

import com.example.mvp.DemoApplication
import com.example.mvp.di.scope.ApplicationScope
import com.example.mvp.net.NetworkModule
import dagger.Component
import retrofit2.Retrofit

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
@ApplicationScope
@Component(
        modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(application: DemoApplication)
    fun retrofit(): Retrofit  // expose Retrofit
}