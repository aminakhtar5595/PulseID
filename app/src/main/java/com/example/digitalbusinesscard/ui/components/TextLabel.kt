package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextLabel(title: String = "NEW") {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge.copy(color = Color.Magenta, fontSize = 16.sp, fontWeight = FontWeight.Medium),
        modifier = Modifier
            .background(color = Color.Magenta.copy(alpha = 0.2f), shape = RoundedCornerShape(15.dp))
            .padding(horizontal = 12.dp)
    )
}
