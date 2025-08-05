package com.example.digitalbusinesscard.ui.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalbusinesscard.ui.model.Menu

@Composable
fun IconTextRow(menu: Menu) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Icon(
            imageVector = menu.icon,
            contentDescription = menu.title,
            modifier = Modifier.size(30.dp),
            tint = Color.DarkGray
        )

        Column {
            Text(
                text = menu.title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W400)
            )
            Text(
                text = menu.description,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W300, fontSize = 18.sp, color = Color.DarkGray)
            )
        }
    }
}