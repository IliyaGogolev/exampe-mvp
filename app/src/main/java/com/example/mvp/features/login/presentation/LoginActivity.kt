package com.example.mvp.features.login.presentation

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.mvp.DemoApplication
import com.example.mvp.R
import com.example.mvp.features.login.di.DaggerLoginComponent
import com.example.mvp.features.login.presentation.presenter.LoginContract
import com.example.mvp.utils.NavigationUtils
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by Iliya Gogolev on 6/28/18.
 */
class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginComponent = DaggerLoginComponent.builder()
                .appComponent((application as DemoApplication).appComponent)
                .build()

        loginComponent.inject(this)
        presenter.view = this

        setContentView(R.layout.activity_login)

        login_buton.setOnClickListener {

            val email = email_input_text.text.toString()
            val password = password_input_text.text.toString()
            presenter.login(email, password)
        }

    }

    override fun showErrorEmailNotValid() {
        Toast.makeText(this, getString(R.string.error_email_not_valid), Toast.LENGTH_LONG).show()
    }

    override fun showErrorLoginFailed() {
        Toast.makeText(this, getString(R.string.error_login_failed), Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    override fun showPlanActivity() {
        NavigationUtils.showPlansActivity(this)
        finish()
    }

    override fun hideKeyboard() {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }


}