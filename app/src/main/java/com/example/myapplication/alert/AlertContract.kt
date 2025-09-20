package com.example.myapplication.alert

import com.example.myapplication.alert.model.AlertModel

interface AlertContract {

    interface View {
        fun showAlerts(alerts: List<AlertModel>)
        fun showError(message: String)
    }

    interface Presenter {
        fun loadAlerts()
        fun onDestroy()
    }

    interface Model {
        fun getAlerts(): List<AlertModel>
    }
}
