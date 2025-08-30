package com.example.myapplication

interface LoginContract {
    interface View {
        fun showValidationError(message: String)
        fun showLoginSuccess()
        fun showLoginError(message: String)
    }

    interface Presenter {
        fun onLoginClicked(email: String, password: String)
    }
}
