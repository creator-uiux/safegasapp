package com.example.myapplication

interface RegisterContract {
    interface View {
        fun showValidationError(message: String)
        fun showRegistrationSuccess()
        fun showRegistrationError(message: String)
    }

    interface Presenter {
        fun onRegisterClicked(fullName: String, email: String, password: String, confirmPassword: String)
    }
}