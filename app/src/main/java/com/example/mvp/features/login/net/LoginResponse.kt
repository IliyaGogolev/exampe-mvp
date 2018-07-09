package com.example.mvp.features.login.net

import com.google.gson.annotations.SerializedName

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
data class LoginResponse (@SerializedName("access_token") val accessToken:String,
                          @SerializedName("token_type") val tokenType:String,
                          @SerializedName("expires_in") val expiresIn:Long,
                          val scope:String,
                          val jti:String)