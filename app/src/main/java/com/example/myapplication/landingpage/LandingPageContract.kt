package com.example.myapplication.landingpage

interface LandingPageContract {
    interface View {
        fun navigateToDashboard()
    }

    interface Presenter {
        fun onGetStartedClicked()
        fun onDestroy()
    }

    interface Model {
        fun saveLandingVisited()
        fun isLandingVisited(): Boolean
    }
}
