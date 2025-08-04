package com.example.digitalbusinesscard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.digitalbusinesscard.ui.navigation.AppNavGraph
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = BackgroundColor
            )
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}