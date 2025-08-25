package com.example.digitalbusinesscard.ui.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digitalbusinesscard.ui.screens.cards.AddCardScreen
import com.example.digitalbusinesscard.ui.screens.cards.CardScreen
import com.example.digitalbusinesscard.ui.screens.contacts.AddContactScreen
import com.example.digitalbusinesscard.ui.screens.contacts.ContactInfoScreen
import com.example.digitalbusinesscard.ui.screens.contacts.ContactsScreen
import com.example.digitalbusinesscard.ui.screens.menu.MenuScreen
import com.example.digitalbusinesscard.ui.screens.onboarding.OnboardingFlow
import com.example.digitalbusinesscard.ui.screens.premium.PremiumScreen
import com.example.digitalbusinesscard.ui.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Screen.AddContact.route, modifier = modifier) {
        composable(Screen.Splash.route) { SplashScreen() }
        composable(Screen.Menu.route) { MenuScreen() }
        composable(Screen.Premium.route) { PremiumScreen(navController) }
        composable(Screen.Onboarding.route) { OnboardingFlow(navController) }
        composable(Screen.Contacts.route) { ContactsScreen(navController) }
        composable(Screen.AddContact.route) { AddContactScreen(navController) }
        composable(Screen.ContactInfo.route) { ContactInfoScreen(navController) }
        composable(Screen.Home.route) { CardScreen(navController) }
        composable(Screen.AddCard.route) { AddCardScreen(navController) }
    }
//    LaunchedEffect(Unit) {
//        delay(2000)
//        navController.navigate("onboarding") {
//            popUpTo("splash") { inclusive = true }
//        }
//    }
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
    object Home : Screen("home")
    object AddCard : Screen("add_card")
}