package com.example.myapplication.dashboard

import android.os.Handler
import android.os.Looper

class DashboardModel : DashboardContract.Model {

    override fun fetchSensorData(callback: (ppm: String, status: String, location: String, lastUpdated: String) -> Unit) {
        // Simulate a network/database fetch with delay
        Handler(Looper.getMainLooper()).postDelayed({
            val ppm = "450 ppm"
            val status = "Normal"
            val location = "Kitchen Sensor #1"
            val lastUpdated = "2025-09-27 14:30"
            callback(ppm, status, location, lastUpdated)
        }, 1500)
    }

    override fun fetchOverviewData(callback: (activeAlerts: String, onlineDevices: String, average: String, peak: String) -> Unit) {
        // Simulated data
        Handler(Looper.getMainLooper()).postDelayed({
            val activeAlerts = "2"
            val onlineDevices = "5"
            val average = "420 ppm"
            val peak = "650 ppm"
            callback(activeAlerts, onlineDevices, average, peak)
        }, 2000)
    }
}
