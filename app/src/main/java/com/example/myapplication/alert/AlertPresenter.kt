package com.example.myapplication.alert

class AlertPresenter(
    private var view: AlertContract.View?,
    private val model: AlertContract.Model
) : AlertContract.Presenter {

    override fun loadAlerts() {
        try {
            val alerts = model.getAlerts()
            view?.showAlerts(alerts)
        } catch (e: Exception) {
            view?.showError("Failed to load alerts: ${e.message}")
        }
    }

    override fun onDestroy() {
        view = null
    }
}
