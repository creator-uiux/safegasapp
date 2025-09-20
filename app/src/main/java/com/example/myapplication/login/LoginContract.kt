package com.example.myapplication.login

interface LoginContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun navigateToHome()
        fun restoreCredentials(email: String, password: String)
    }

    interface Presenter {
        fun onLoginClicked(email: String, password: String, remember: Boolean)
        fun loadSavedCredentials()
        fun onDestroy()
    }

    interface Model {
        fun saveCredentials(email: String, password: String)
        fun getSavedCredentials(): Pair<String?, String?>
    }
}
