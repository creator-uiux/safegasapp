package com.example.myapplication

class HomeModelImpl : HomeContract.Model {

    override fun getGasLevel(callback: (Int?, String?) -> Unit) {
        // Simulate data fetch (e.g., from sensor or API)
        val simulatedLevel = 72 // Example value
        callback(simulatedLevel, null)
    }

    override fun logoutUser() {
        // Clear session or token
    }
}
