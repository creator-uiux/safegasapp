package com.example.myapplication.register

import android.content.Context

class RegisterModel(private val context: Context) : RegisterContract.Model {

    private val sharedPref = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)

    override fun saveUser(fullName: String, email: String, password: String, location: String?) {
        sharedPref.edit()
            .putString("fullName", fullName)
            .putString("email", email)
            .putString("password", password)
            .putString("location", location)
            .apply()
    }
}
