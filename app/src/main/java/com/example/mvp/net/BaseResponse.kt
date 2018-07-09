package com.example.mvp.net

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
data class BaseResponse<T>(
        var result: T?,
        var error: String?
)



