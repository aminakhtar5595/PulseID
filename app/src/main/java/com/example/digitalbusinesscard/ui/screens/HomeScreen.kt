package com.example.digitalbusinesscard.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(name: String) {
    Column (
        modifier = Modifier
            .padding(20.dp)
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),

        ) {
            Text(text = "Create Card")
        }

        Spacer(modifier = Modifier
            .padding(5.dp))

        Button(onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Share Card")
        }
    }
    
}
