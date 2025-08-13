package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactCard(initial: String, image: Int, title: String, company: String) {
    Text(
        text = initial,
        style = MaterialTheme.typography.titleLarge.copy(color = Color.DarkGray), modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
    )
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().background(color = Color.White).padding(5.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier.size(60.dp)
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.Black, fontWeight = FontWeight.Light, fontSize = 20.sp)
                )
                Text(
                    text = company,
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.Gray, fontWeight = FontWeight.Light, fontSize = 20.sp)
                )
            }
        }
        TextLabel()
    }
}