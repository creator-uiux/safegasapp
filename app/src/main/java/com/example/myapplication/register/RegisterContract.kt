package com.example.myapplication.register

interface RegisterContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun showSuccess(message: String)
        fun navigateToLogin()
    }

    interface Presenter {
        fun onRegisterClicked(
            fullName: String,
            email: String,
            password: String,
            confirmPassword: String,
            location: String?,
            termsAccepted: Boolean
        )
        fun onDestroy()
    }

    interface Model {
        fun saveUser(fullName: String, email: String, password: String, location: String?)
    }
}
