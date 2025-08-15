package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonWithIcon(
    contentColor: Color = Color.DarkGray,
    title: String,
    icon: ImageVector,
    widthFraction: Float = 0.7f,
) {
    Button(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth(widthFraction)
            .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(contentColor = contentColor, containerColor = Color.Transparent),
        contentPadding = PaddingValues(vertical = 15.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(28.dp)
        )
        Text(title, style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp), modifier = Modifier.padding(start = 10.dp))
    }
}