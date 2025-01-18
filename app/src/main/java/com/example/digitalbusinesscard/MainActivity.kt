package com.example.digitalbusinesscard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.digitalbusinesscard.ui.navigation.AppNavGraph
import com.example.digitalbusinesscard.ui.screens.EditCardScreen
import com.example.digitalbusinesscard.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}