package com.example.digitalbusinesscard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.digitalbusinesscard.ui.screens.EditCardScreen
import com.example.digitalbusinesscard.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeScreen(name = "Hello Amin Akhtar")
            EditCardScreen()
        }
    }
}