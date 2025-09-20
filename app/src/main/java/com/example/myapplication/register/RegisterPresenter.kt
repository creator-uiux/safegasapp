package com.example.myapplication.register

class RegisterPresenter(
    private var view: RegisterContract.View?,
    private val model: RegisterContract.Model
) : RegisterContract.Presenter {

    override fun onRegisterClicked(
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String,
        location: String?,
        termsAccepted: Boolean
    ) {
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            view?.showError("All fields except location are required.")
            return
        }

        if (password != confirmPassword) {
            view?.showError("Passwords do not match.")
            return
        }

        if (!termsAccepted) {
            view?.showError("You must agree to the Terms and Privacy Policy.")
            return
        }

        model.saveUser(fullName, email, password, location)
        view?.showSuccess("Account created successfully!")
        view?.navigateToLogin()
    }

    override fun onDestroy() {
        view = null
    }
}
