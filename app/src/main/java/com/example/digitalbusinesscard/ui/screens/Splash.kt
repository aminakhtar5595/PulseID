package com.example.digitalbusinesscard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import com.example.digitalbusinesscard.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen() {
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = "Splash Icon")

        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Digital Business Card",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
        ))

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Don't carry around business cards, use a digital one on your phone",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin
            ))

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text(text = "LET'S GO")

        }
    }
}