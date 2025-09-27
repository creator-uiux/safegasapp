package com.example.myapplication.landingpage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.dashboard.DashboardActivity

class LandingPageActivity : Activity(), LandingPageContract.View {

    private lateinit var presenter: LandingPageContract.Presenter
    private lateinit var getStartedBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page) // your layout

        // Init Model + Presenter
        val model = LandingPageModel(this)
        presenter = LandingPagePresenter(this, model)

        // Init UI
        getStartedBtn = findViewById(R.id.getStartedBtn)

        // Listeners
        getStartedBtn.setOnClickListener {
            presenter.onGetStartedClicked()
        }
    }

    override fun navigateToDashboard() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
