package com.example.myapplication.alert

import com.example.myapplication.alert.model.AlertModel

class AlertDataModel : AlertContract.Model {

    override fun getAlerts(): List<AlertModel> {
        // Sample static data
        return listOf(
            AlertModel(
                title = "Gas Leak Detected",
                description = "Danger! Gas Leak in the Kitchen.",
                sensor = "Kitchen Sensor",
                type = "Danger",
                timeAgo = "2 min ago"
            ),
            AlertModel(
                title = "Low Gas Pressure",
                description = "Warning: Pressure below safe threshold.",
                sensor = "Main Pipeline",
                type = "Warning",
                timeAgo = "5 min ago"
            ),
            AlertModel(
                title = "System Check",
                description = "Routine check completed successfully.",
                sensor = "Control Unit",
                type = "Info",
                timeAgo = "10 min ago"
            )
        )
    }
}
