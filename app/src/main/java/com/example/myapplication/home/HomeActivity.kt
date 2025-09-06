package com.example.myapplication.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.home.HomeContract
import com.example.myapplication.home.HomeModelImpl
import com.example.myapplication.home.HomePresenter
import com.example.myapplication.R
import com.example.myapplication.login.LoginActivity

class HomeActivity : Activity(), HomeContract.View {

    private lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // Initialize presenter
        presenter = HomePresenter(this, HomeModelImpl())

        // Retrieve user email from SharedPreferences
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val userEmail = sharedPref.getString("email", "User")

        // Set welcome message

        // Set up buttons
        val checkGasButton = findViewById<Button>(R.id.btnCheckGasLevels)
        val logoutButton = findViewById<Button>(R.id.btnLogout)

        checkGasButton.setOnClickListener {
            presenter.onCheckGasLevelsClicked()
        }

        logoutButton.setOnClickListener {
            presenter.onLogoutClicked()
        }
    }

    override fun showGasLevel(level: Int) {
        Toast.makeText(this, "Gas Level: $level%", Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun showLoading() {
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        // Add spinner logic here if needed
    }
}