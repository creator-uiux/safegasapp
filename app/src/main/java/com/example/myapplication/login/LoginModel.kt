package com.example.myapplication.login

import android.content.Context

class LoginModel(private val context: Context) : LoginContract.Model {

    private val sharedPref = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)

    override fun saveCredentials(email: String, password: String) {
        sharedPref.edit()
            .putString("email", email)
            .putString("password", password)
            .apply()
    }

    override fun getSavedCredentials(): Pair<String?, String?> {
        val email = sharedPref.getString("email", null)
        val password = sharedPref.getString("password", null)
        return Pair(email, password)
    }
}
