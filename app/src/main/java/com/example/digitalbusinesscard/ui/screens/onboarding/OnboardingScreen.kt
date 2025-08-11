package com.example.digitalbusinesscard.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun OnboardingScreen(
    imageRes: Int,
    title: String,
    description: String,
    isLastPage: Boolean,
    onStartClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Onboarding Image",
            modifier = Modifier.size(250.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.W500),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp, top = 60.dp)
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

        if (isLastPage) {
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                onClick = onStartClick,
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(vertical = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = LightBlueColor
                ),
            ) {
                Text(
                    "LET'S GO",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W400, fontSize = 18.sp)
                )
            }
        }
    }
}