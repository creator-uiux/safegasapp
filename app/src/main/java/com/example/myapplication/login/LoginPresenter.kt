package com.example.myapplication.login

import android.app.Activity
import android.util.Patterns

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun onLoginClicked(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showValidationError("Email and password are required.")
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.showValidationError("Invalid email format.")
            return
        }

        val context = view as Activity
        val sharedPref = context.getSharedPreferences("UserData", Activity.MODE_PRIVATE)
        val savedEmail = sharedPref.getString("email", null)
        val savedPassword = sharedPref.getString("password", null)

        if (email == savedEmail && password == savedPassword) {
            view.showLoginSuccess()
        } else {
            view.showLoginError("Invalid email or password.")
        }
    }
}