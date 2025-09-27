package com.example.myapplication.landingpage

class LandingPagePresenter(
    private var view: LandingPageContract.View?,
    private val model: LandingPageContract.Model
) : LandingPageContract.Presenter {

    override fun onGetStartedClicked() {
        // Save that landing page was visited
        model.saveLandingVisited()

        // Navigate
        view?.navigateToDashboard()
    }

    override fun onDestroy() {
        view = null
    }
}
