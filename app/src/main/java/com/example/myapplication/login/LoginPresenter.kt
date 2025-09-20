package com.example.myapplication.login

class LoginPresenter(
    private var view: LoginContract.View?,
    private val model: LoginContract.Model
) : LoginContract.Presenter {

    override fun onLoginClicked(email: String, password: String, remember: Boolean) {
        if (email.isEmpty() || password.isEmpty()) {
            view?.showError("Email and password are required.")
            return
        }

        val (savedEmail, savedPassword) = model.getSavedCredentials()

        if (savedEmail != null && savedPassword != null &&
            savedEmail == email && savedPassword == password
        ) {
            if (remember) {
                model.saveCredentials(email, password)
            }
            view?.navigateToHome()
        } else {
            view?.showError("Invalid email or password.")
        }
    }

    override fun loadSavedCredentials() {
        val (email, password) = model.getSavedCredentials()
        if (email != null && password != null) {
            view?.restoreCredentials(email, password)
        }
    }

    override fun onDestroy() {
        view = null
    }
}
