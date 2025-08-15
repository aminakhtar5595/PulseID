package com.example.digitalbusinesscard
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.digitalbusinesscard.ui.MainScreen
import com.example.digitalbusinesscard.ui.navigation.AppNavGraph
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()

            systemUiController.setSystemBarsColor(
                color = BackgroundColor
            )
            MainScreen()
        }
    }
}