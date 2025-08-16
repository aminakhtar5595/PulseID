package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun IconTextRow(menu: Menu, iconColor: Color = Color.Gray, descriptionFontSize: TextUnit = 18.sp) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Icon(
            imageVector = menu.icon,
            contentDescription = menu.title,
            modifier = Modifier.size(25.dp),
            tint = iconColor
        )

        Column {
            Text(
                text = menu.title,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 19.sp, color = Color.DarkGray)
            )
            if (menu.description.isNotBlank()) {
                Text(
                    text = menu.description,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = descriptionFontSize,
                        color = Color.Gray
                    )
                )
            }
        }
    }
}