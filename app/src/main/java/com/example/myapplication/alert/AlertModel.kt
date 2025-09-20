package com.example.myapplication.alert.model

data class AlertModel(
    val title: String,
    val description: String,
    val sensor: String,
    val type: String, // Danger, Warning, Info
    val timeAgo: String
)
