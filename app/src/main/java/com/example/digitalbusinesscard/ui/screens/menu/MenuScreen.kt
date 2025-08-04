package com.example.digitalbusinesscard.ui.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import androidx.compose.material3.HorizontalDivider
import com.example.digitalbusinesscard.ui.theme.BorderColor

@Composable
fun MenuScreen() {
    Column (
        modifier = Modifier.fillMaxSize().background(color = BackgroundColor).padding(vertical = 20.dp)
    ) {
        Text(
            text = "Menu",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W500), modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = BorderColor)
    }
}