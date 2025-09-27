package com.example.myapplication.dashboard

class DashboardPresenter(
    private var view: DashboardContract.View?,
    private val model: DashboardContract.Model
) : DashboardContract.Presenter {

    override fun loadDashboardData() {
        view?.showLoading()

        model.fetchSensorData { ppm, status, location, lastUpdated ->
            view?.updateSensorData(ppm, status, location, lastUpdated)
        }

        model.fetchOverviewData { activeAlerts, onlineDevices, average, peak ->
            view?.updateOverview(activeAlerts, onlineDevices, average, peak)
            view?.hideLoading()
        }
    }

    override fun onEmergencyClicked() {
        view?.showToast("Calling emergency services… 🚨")
        // Here you could trigger a phone dialer intent or send an alert
    }

    override fun onMuteClicked() {
        view?.showToast("Alerts muted 🔇")
        // Add mute logic here
    }

    override fun onDestroy() {
        view = null // prevent memory leaks
    }
}
