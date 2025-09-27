package com.example.myapplication.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R
import com.example.myapplication.dashboard.DashboardActivity
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.landingpage.LandingPageActivity
import com.example.myapplication.register.RegisterActivity

class LoginActivity : Activity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberCheck: CheckBox
    private lateinit var signInButton: Button
    private lateinit var googleButton: Button
    private lateinit var bottomCreate: TextView
    private lateinit var forgotPassword: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Init UI
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        rememberCheck = findViewById(R.id.checkRemember)
        signInButton = findViewById(R.id.btnSignIn)
        googleButton = findViewById(R.id.btnGoogle)
        bottomCreate = findViewById(R.id.bottomCreate)
        forgotPassword = findViewById(R.id.tvForgot)
        progressBar = ProgressBar(this).apply { visibility = android.view.View.GONE }

        // MVP init
        val model = LoginModel(this)
        presenter = LoginPresenter(this, model)

        // Load saved credentials
        presenter.loadSavedCredentials()

        // Listeners
        signInButton.setOnClickListener {
            presenter.onLoginClicked(
                emailEditText.text.toString().trim(),
                passwordEditText.text.toString().trim(),
                rememberCheck.isChecked
            )
        }

        googleButton.setOnClickListener {
            Toast.makeText(this, "Google sign-in not implemented yet", Toast.LENGTH_SHORT).show()
        }

        bottomCreate.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        forgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show()
        }
    }

    // --- View implementation ---
    override fun showLoading() {
        progressBar.visibility = android.view.View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = android.view.View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LandingPageActivity::class.java))
        finish()
    }

    override fun restoreCredentials(email: String, password: String) {
        emailEditText.setText(email)
        passwordEditText.setText(password)
        rememberCheck.isChecked = true
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
