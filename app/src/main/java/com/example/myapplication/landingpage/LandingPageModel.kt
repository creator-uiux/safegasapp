package com.example.myapplication.landingpage

import android.content.Context

class LandingPageModel(context: Context) : LandingPageContract.Model {

    private val sharedPref = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)

    override fun saveLandingVisited() {
        sharedPref.edit().putBoolean("landingVisited", true).apply()
    }

    override fun isLandingVisited(): Boolean {
        return sharedPref.getBoolean("landingVisited", false)
    }
}
