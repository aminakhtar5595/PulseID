package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.digitalbusinesscard.R

@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(totalPages) { index ->
            if (index == currentPage) {
                Image(
                    painter = painterResource(id = R.drawable.active_indicator),
                    contentDescription = "Onboarding Image",
                    modifier = Modifier.size(25.dp)
                )
            } else {
                Text(
                    text = "●",
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.LightGray)
                )
            }
        }
    }
}