package com.example.myapplication.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R
import com.example.myapplication.login.LoginActivity

class RegisterActivity : Activity(), RegisterContract.View {

    private lateinit var presenter: RegisterContract.Presenter

    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var etLocation: EditText
    private lateinit var checkTerms: CheckBox
    private lateinit var btnCreateAccount: Button
    private lateinit var btnGoogleRegister: Button
    private lateinit var tvAlreadyAccount: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        // Init UI
        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etLocation = findViewById(R.id.etLocation)
        checkTerms = findViewById(R.id.checkTerms)
        btnCreateAccount = findViewById(R.id.btnCreateAccount)
        btnGoogleRegister = findViewById(R.id.btnGoogleRegister)
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount)
        progressBar = ProgressBar(this).apply { visibility = android.view.View.GONE }

        // MVP setup
        val model = RegisterModel(this)
        presenter = RegisterPresenter(this, model)

        // Listeners
        btnCreateAccount.setOnClickListener {
            presenter.onRegisterClicked(
                etFullName.text.toString().trim(),
                etEmail.text.toString().trim(),
                etPassword.text.toString().trim(),
                etConfirmPassword.text.toString().trim(),
                etLocation.text.toString().trim().ifEmpty { null },
                checkTerms.isChecked
            )
        }

        btnGoogleRegister.setOnClickListener {
            Toast.makeText(this, "Google sign-up not implemented yet", Toast.LENGTH_SHORT).show()
        }

        tvAlreadyAccount.setOnClickListener {
            navigateToLogin()
        }
    }

    // --- View Implementation ---
    override fun showLoading() {
        progressBar.visibility = android.view.View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = android.view.View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
