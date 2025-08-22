package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun InputWithIcon(
    icon: ImageVector,
    input: String,
    placeholder: String,
    onInputChange: (String) -> Unit,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Close form icon",
            modifier = Modifier.size(25.dp)
        )
        OutlinedTextField(
            value = input,
            onValueChange = onInputChange,
            label = { Text(placeholder) },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}