package com.example.myapplication.home

class HomePresenter(
    private val view: HomeContract.View,
    private val model: HomeContract.Model
) : HomeContract.Presenter {

    override fun onCheckGasLevelsClicked() {
        view.showLoading()

        model.getGasLevel { level, error ->
            view.hideLoading()
            if (error != null) {
                view.showError("Failed to retrieve gas level: $error")
            } else if (level != null) {
                view.showGasLevel(level)
            } else {
                view.showError("Gas level data is unavailable.")
            }
        }
    }



    override fun onLogoutClicked() {
        model.logoutUser()
        view.navigateToLogin()
    }
}