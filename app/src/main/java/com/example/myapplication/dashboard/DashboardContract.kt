package com.example.myapplication.dashboard

interface DashboardContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun updateSensorData(ppm: String, status: String, location: String, lastUpdated: String)
        fun updateOverview(activeAlerts: String, onlineDevices: String, average: String, peak: String)
        fun navigateToLogin()
        fun showToast(message: String)
    }

    interface Presenter {
        fun loadDashboardData()
        fun onEmergencyClicked()
        fun onMuteClicked()
        fun onDestroy()
    }

    interface Model {
        fun fetchSensorData(callback: (ppm: String, status: String, location: String, lastUpdated: String) -> Unit)
        fun fetchOverviewData(callback: (activeAlerts: String, onlineDevices: String, average: String, peak: String) -> Unit)
    }
}
