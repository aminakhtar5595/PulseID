package com.example.digitalbusinesscard.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digitalbusinesscard.ui.screens.EditCardScreen
import com.example.digitalbusinesscard.ui.screens.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Edit.route) {
        composable("homeScreen/{fullName}/{jobTitle}/{company}/{phoneNumber}/{email}") { backStackEntry ->
            val fullName = backStackEntry.arguments?.getString("fullName") ?: "Default Name"
            val jobTitle = backStackEntry.arguments?.getString("jobTitle") ?: "Unknown"
            val company = backStackEntry.arguments?.getString("company") ?: "N/A"
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: "N/A"
            val email = backStackEntry.arguments?.getString("email") ?: "N/A"

            HomeScreen(navController, fullName, jobTitle, company, phoneNumber, email)
        }

        composable(Screen.Edit.route) { EditCardScreen(navController) }
    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object Edit : Screen("editCardScreen")
}