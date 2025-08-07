package com.example.digitalbusinesscard.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digitalbusinesscard.ui.screens.menu.MenuScreen
import com.example.digitalbusinesscard.ui.screens.premium.PremiumScreen
import com.example.digitalbusinesscard.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Premium.route) {
        composable(Screen.Splash.route) { SplashScreen() }
        composable(Screen.Menu.route) { MenuScreen() }
        composable(Screen.Premium.route) { PremiumScreen() }
    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Menu : Screen("menu")
    object Splash : Screen("splash")
    object Premium : Screen("premium")
}