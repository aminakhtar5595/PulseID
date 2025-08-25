package com.example.digitalbusinesscard.data.model

data class Contact (
    val id: String = System.currentTimeMillis().toString(), // unique ID
    val cardType: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val job: String,
    val department: String,
    val company: String,
    val website: String
)