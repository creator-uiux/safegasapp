package com.example.myapplication.alert

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.alert.model.AlertModel

class AlertActivity : Activity(), AlertContract.View {

    private lateinit var presenter: AlertContract.Presenter
    private lateinit var alertsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alert_page_activity)

        // Initialize container
        alertsContainer = findViewById(R.id.alertsContainer)

        // Initialize MVP
        val model = AlertDataModel()
        presenter = AlertPresenter(this, model)

        // Load alerts
        presenter.loadAlerts()
    }

    override fun showAlerts(alerts: List<AlertModel>) {
        alertsContainer.removeAllViews()
        for (alert in alerts) {
            val view = layoutInflater.inflate(R.layout.alert_item, alertsContainer, false)

            val titleText = view.findViewById<TextView>(R.id.alertTitle)
            val descText = view.findViewById<TextView>(R.id.alertDesc)
            val sensorText = view.findViewById<TextView>(R.id.alertSensor)

            titleText.text = alert.title
            descText.text = alert.description
            sensorText.text = "${alert.sensor} • ${alert.type} • ${alert.timeAgo}"

            alertsContainer.addView(view)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
