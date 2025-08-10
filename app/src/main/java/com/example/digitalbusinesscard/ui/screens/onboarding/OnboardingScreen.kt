package com.example.digitalbusinesscard.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalbusinesscard.ui.components.PageIndicator
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun OnboardingScreen(
    imageRes: Int,
    title: String,
    description: String,
    currentPage: Int,
    totalPages: Int,
    onSkipClick: () -> Unit,
    leftLabel: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor).padding(horizontal = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Onboarding Image",
                modifier = Modifier.size(250.dp),
            )

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp, top = 60.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = leftLabel,
                style = MaterialTheme.typography.bodyLarge.copy(color = LightBlueColor),
                modifier = Modifier.clickable { onSkipClick() }.padding(start = 50.dp)
            )
            PageIndicator(currentPage = currentPage, totalPages = totalPages)
        }
    }
}