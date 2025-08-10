package com.example.digitalbusinesscard.ui.screens.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.digitalbusinesscard.R

@Composable
fun OnboardingFlow() {
    val navController = rememberNavController()
    var currentPage by remember { mutableStateOf(0) }

    val onboardingItems = listOf(
        Triple(R.drawable.onboarding_icon_one, "Digital Business Card", "Don't carry around business cards, use a digital one on your phone"),
        Triple(R.drawable.onboarding_icon_two, "Scan to add", "Just let someone scan your QR Code to add you as a contact"),
        Triple(R.drawable.onboarding_icon_three, "Profile data", "Add your name, email address, phone number, company name and much more..."),
        Triple(R.drawable.onboarding_icon_four, "Start now", "Create your personalized QR Code now!"),
    )
}