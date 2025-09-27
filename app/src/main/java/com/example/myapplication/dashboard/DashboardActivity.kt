package com.example.myapplication.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.R
import com.example.myapplication.login.LoginActivity

class DashboardActivity : Activity(), DashboardContract.View {

    private lateinit var presenter: DashboardContract.Presenter

    // UI Elements
    private lateinit var tvPpm: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvLastUpdated: TextView
    private lateinit var tvActiveAlertsValue: TextView
    private lateinit var tvOnlineDevicesValue: TextView
    private lateinit var tvTodayAverageValue: TextView
    private lateinit var tvPeakValue: TextView

    private lateinit var btnCallEmergency: Button
    private lateinit var btnMute: Button

    // Bottom Navigation
    private lateinit var navHome: LinearLayout
    private lateinit var navAlerts: LinearLayout
    private lateinit var navHistory: LinearLayout
    private lateinit var navSettings: LinearLayout

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        initViews()

        // MVP setup
        val model = DashboardModel()
        presenter = DashboardPresenter(this, model)

        // Load data
        presenter.loadDashboardData()

        // Listeners
        btnCallEmergency.setOnClickListener { presenter.onEmergencyClicked() }
        btnMute.setOnClickListener { presenter.onMuteClicked() }

        navHome.setOnClickListener { showToast("Home selected") }
        navAlerts.setOnClickListener { showToast("Alerts selected") }
        navHistory.setOnClickListener { showToast("History selected") }
        navSettings.setOnClickListener { showToast("Settings selected") }
    }

    private fun initViews() {
        tvPpm = findViewById(R.id.tvPpm)
        tvStatus = findViewById(R.id.tvStatus)
        tvLocation = findViewById(R.id.tvLocation)
        tvLastUpdated = findViewById(R.id.tvLastUpdated)
        tvActiveAlertsValue = findViewById(R.id.tvActiveAlertsValue)
        tvOnlineDevicesValue = findViewById(R.id.tvOnlineDevicesValue)
        tvTodayAverageValue = findViewById(R.id.tvTodayAverageValue)
        tvPeakValue = findViewById(R.id.tvPeakValue)

        btnCallEmergency = findViewById(R.id.btnCallEmergency)
        btnMute = findViewById(R.id.btnMute)

        navHome = findViewById(R.id.navHome)
        navAlerts = findViewById(R.id.navAlerts)
        navHistory = findViewById(R.id.navHistory)
        navSettings = findViewById(R.id.navSettings)

        progressBar = findViewById(R.id.progressBar)
    }

    // --- View Implementation ---
    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun updateSensorData(ppm: String, status: String, location: String, lastUpdated: String) {
        tvPpm.text = ppm
        tvStatus.text = status
        tvLocation.text = location
        tvLastUpdated.text = lastUpdated
    }

    override fun updateOverview(activeAlerts: String, onlineDevices: String, average: String, peak: String) {
        tvActiveAlertsValue.text = activeAlerts
        tvOnlineDevicesValue.text = onlineDevices
        tvTodayAverageValue.text = average
        tvPeakValue.text = peak
    }

    override fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
