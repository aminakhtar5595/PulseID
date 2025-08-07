package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Subscription(
    title: String,
    description: String,
    icon: ImageVector
) {
    Row (
        modifier = Modifier.fillMaxWidth().border(2.dp, color = Color.Black, RoundedCornerShape(15.dp)).padding(horizontal = 22.dp, vertical = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Light)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Light, color = Color.Gray, fontSize = 20.sp)
            )
        }
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color.Unspecified
        )
    }
}