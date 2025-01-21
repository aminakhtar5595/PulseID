package com.example.digitalbusinesscard.ui.navigation
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digitalbusinesscard.ui.screens.EditCardScreen
import com.example.digitalbusinesscard.ui.screens.HomeScreen
import com.example.digitalbusinesscard.ui.viewmodels.BusinessCardViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {

    val businessCardViewModel : BusinessCardViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController, businessCardViewModel) }
        composable(Screen.Edit.route) { EditCardScreen(navController, businessCardViewModel) }
    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object Edit : Screen("editCardScreen")
}