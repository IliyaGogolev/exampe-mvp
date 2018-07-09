package com.example.mvp.features.login.presentation.presenter

import com.example.mvp.features.login.domain.LoginUseCase
import com.example.mvp.utils.ext.isEmailValid
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class LoginPresenter (val loginUseCase:LoginUseCase) : LoginContract.Presenter {

    override lateinit var view: LoginContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun validateEmail(email: String): Boolean = email.isEmailValid()

    override fun login(email: String, password: String) {
        if (!email.isEmailValid()) {
            view.showErrorEmailNotValid()
        } else {
            view.hideKeyboard()
            view.showProgressBar()
            loginUseCase.login(email, password)
                    .subscribe({
                        view.hideProgressBar()
                        view.showPlanActivity()
                    },{
                        view.hideProgressBar()
                        view.showErrorLoginFailed()
                    }
            )
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}