package com.example.mvp.net

import com.example.mvp.di.scope.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
@Module
class NetworkModule {


    @ApplicationScope
    @Provides
    fun createRetrofit(gson: Gson, client: OkHttpClient): Retrofit {

        return Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //                .addCallAdapterFactory(ErrorHandlingCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl("http://private-bbbe92-cleanarchitecturedemo.apiary-mock.com/")
                .build()
    }

    @ApplicationScope
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @ApplicationScope
    @Provides
    fun createOkHttpClient(): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        okBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okBuilder.readTimeout(30, TimeUnit.SECONDS)
        okBuilder.writeTimeout(30, TimeUnit.SECONDS)

        val interceptor = HttpLoggingInterceptor();
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okBuilder.addInterceptor(interceptor)
        return okBuilder.build()
    }


}
