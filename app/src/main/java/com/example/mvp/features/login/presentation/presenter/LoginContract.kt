package com.example.mvp.features.login.presentation.presenter

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
interface LoginContract {

    interface Presenter {
        var view: LoginContract.View

        fun validateEmail(email:String):Boolean
        fun login(email:String, password: String)
        fun onCleared()
    }

    interface View {
        fun showErrorEmailNotValid()
        fun showErrorLoginFailed()
        fun showProgressBar()
        fun hideProgressBar()
        fun showPlanActivity()
        fun hideKeyboard()
    }
}