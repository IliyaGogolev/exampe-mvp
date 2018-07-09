package com.example.mvp.features.login.domain

import com.example.mvp.features.login.net.LoginAPIService
import com.example.mvp.features.login.net.LoginResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class LoginUseCase
@Inject
internal constructor(private val apiService: LoginAPIService) {

    val map = mutableMapOf<String,String>()

    fun login(userName: String, password: String): Single<LoginResponse> {

        map.put("username", userName)
        map.put("password", password)
        map.put("grant_type", "password")
        map.put("client_id", "XW9LtUlJfcCHMJbLyLen3lglY4COUgmCQErwjze7")
        map.put("client_secret", "ae55LjKyfVAf9dWaUX9HwoU5tpwHAVn2jKh8Of9zu3TP4zlD7JwguJhDYxXRT9zR2iuOIfHLrNiOAQSyAfRFs6dI7uXE8Yg7l3yyw7NTABnLr94VuPFKUOaaaCZ7xAv3")

        return apiService.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
