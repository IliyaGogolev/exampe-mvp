package com.example.mvp.di

import android.content.Context
import com.example.mvp.DemoApplication
import dagger.Module
import dagger.Provides

/**
 * Created by Iliya Gogolev on 6/28/18.
 */

@Module
class AppModule(val app: DemoApplication) {

    @Provides
    fun provideApp(): DemoApplication = app

    @Provides
    fun provideAppContext(): Context = app.applicationContext

}
