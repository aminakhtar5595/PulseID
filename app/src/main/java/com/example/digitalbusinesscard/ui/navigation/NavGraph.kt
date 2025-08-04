package com.example.digitalbusinesscard.ui.navigation
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digitalbusinesscard.ui.screens.splash.SplashScreen
import com.example.digitalbusinesscard.ui.viewmodels.BusinessCardViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {

    val businessCardViewModel : BusinessCardViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen() }
    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object Edit : Screen("editCardScreen")
    object Splash : Screen("splash")
}