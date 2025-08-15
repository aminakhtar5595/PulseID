package com.example.digitalbusinesscard.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digitalbusinesscard.ui.screens.contacts.AddContactScreen
import com.example.digitalbusinesscard.ui.screens.contacts.ContactInfoScreen
import com.example.digitalbusinesscard.ui.screens.contacts.ContactsScreen
import com.example.digitalbusinesscard.ui.screens.menu.MenuScreen
import com.example.digitalbusinesscard.ui.screens.onboarding.OnboardingFlow
import com.example.digitalbusinesscard.ui.screens.premium.PremiumScreen
import com.example.digitalbusinesscard.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.ContactInfo.route) {
        composable(Screen.Splash.route) { SplashScreen() }
        composable(Screen.Menu.route) { MenuScreen() }
        composable(Screen.Premium.route) { PremiumScreen() }
        composable(Screen.Onboarding.route) { OnboardingFlow() }
        composable(Screen.Contacts.route) { ContactsScreen() }
        composable(Screen.AddContact.route) { AddContactScreen() }
        composable(Screen.ContactInfo.route) { ContactInfoScreen() }
    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Menu : Screen("menu")
    object Splash : Screen("splash")
    object Premium : Screen("premium")
    object Onboarding : Screen("onboarding")
    object Contacts : Screen("contacts")
    object AddContact : Screen("add_contact")
    object ContactInfo : Screen("contact_info")

}