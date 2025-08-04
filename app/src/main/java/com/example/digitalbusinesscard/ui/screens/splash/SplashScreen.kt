package com.example.digitalbusinesscard.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import com.example.digitalbusinesscard.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.digitalbusinesscard.ui.theme.BackgroundColor

@Composable
fun SplashScreen() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor),
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo", modifier = Modifier.size(120.dp))
        }

        Image(painter = painterResource(id = R.drawable.app_developer_logo),
            contentDescription = "App Developer Logo", modifier = Modifier.size(180.dp).align(
                Alignment.BottomCenter))
    }
}