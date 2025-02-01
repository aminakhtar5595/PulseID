package com.example.digitalbusinesscard.ui.viewmodels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BusinessCardViewModel: ViewModel() {
    var fullName by mutableStateOf("")
    var jobTitle by mutableStateOf("")
    var company by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var email by mutableStateOf("")

    fun isFormValid (): Boolean {
        return fullName.isNotEmpty() && jobTitle.isNotEmpty() && company.isNotEmpty() && phoneNumber.isNotEmpty() && email.isNotEmpty()
    }
}