package com.example.myapplication.register

import android.util.Patterns

class RegisterPresenter(private val view: RegisterContract.View) : RegisterContract.Presenter {

    override fun onRegisterClicked(fullName: String, email: String, password: String, confirmPassword: String) {
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            view.showValidationError("All fields are required.")
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.showValidationError("Invalid email format.")
            return
        }

        if (password.length < 6) {
            view.showValidationError("Password must be at least 6 characters long.")
            return
        }

        if (password != confirmPassword) {
            view.showValidationError("Passwords do not match.")
            return
        }

        // Simulate registration success
        view.showRegistrationSuccess()
    }
}