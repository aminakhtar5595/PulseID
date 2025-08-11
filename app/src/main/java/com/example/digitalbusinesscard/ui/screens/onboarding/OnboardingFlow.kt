package com.example.digitalbusinesscard.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.digitalbusinesscard.R
import com.example.digitalbusinesscard.ui.components.PageIndicator
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingFlow() {
    val navController = rememberNavController()
    val onboardingItems = listOf(
        Triple(R.drawable.onboarding_icon_one, "Digital Business Card", "Don't carry around business cards, use a digital one on your phone"),
        Triple(R.drawable.onboarding_icon_two, "Scan to add", "Just let someone scan your QR Code to add you as a contact"),
        Triple(R.drawable.onboarding_icon_three, "Profile data", "Add your name, email address, phone number, company name and much more..."),
        Triple(R.drawable.onboarding_icon_four, "Start now", "Create your personalized QR Code now!"),
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val currentPage = pagerState.currentPage
    val isLastPage = currentPage == onboardingItems.lastIndex

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 40.dp, vertical = 20.dp)
    ) {
        Column {
            HorizontalPager(
                count = onboardingItems.size,
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                val (image, title, desc) = onboardingItems[page]
                OnboardingScreen(
                    imageRes = image,
                    title = title,
                    description = desc,
                    isLastPage = isLastPage,
                    onStartClick = {
                        navController.navigate("home") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isLastPage) "" else "Skip",
                    style = MaterialTheme.typography.bodyLarge.copy(color = LightBlueColor),
                    modifier = Modifier.clickable {
                        if (isLastPage) {
                            navController.navigate("home") {
                                popUpTo("onboarding") { inclusive = true }
                            }
                        } else {
                            coroutineScope.launch {
                                pagerState.scrollToPage(onboardingItems.lastIndex)
                            }
                        }
                    }.padding(start = 50.dp)
                )

                PageIndicator(currentPage = currentPage, totalPages = onboardingItems.size)
            }
        }
    }
}
