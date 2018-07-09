package com.example.mvp.features.login.net

import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
interface LoginAPIService {

    @POST("/archdemo/login")
    fun login(@QueryMap fields:Map<String, String>): Single<LoginResponse>

}