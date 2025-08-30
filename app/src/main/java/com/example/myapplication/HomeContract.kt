package com.example.myapplication

interface HomeContract {
    interface View {
        fun showGasLevel(level: Int)
        fun showError(message: String)

        fun navigateToLogin()
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onCheckGasLevelsClicked()

        fun onLogoutClicked()
    }

    interface Model {
        fun getGasLevel(callback: (Int?, String?) -> Unit)
        fun logoutUser()
    }
}
