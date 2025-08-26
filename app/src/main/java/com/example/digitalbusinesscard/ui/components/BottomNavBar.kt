package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digitalbusinesscard.ui.model.BottomNavItem
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Cards", "home", Icons.Outlined.DateRange),
        BottomNavItem("Contacts", "contacts", Icons.Outlined.AccountBox),
        BottomNavItem("Premium", "premium", Icons.Outlined.Lock),
        BottomNavItem("Menu", "menu", Icons.Outlined.Menu)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val excludedRoutes = listOf(
        "onboarding",
        "splash",
        "premium",
        "add_card",
        "contact_info",
        "add_contact"
    )

    if (excludedRoutes.none { currentRoute?.startsWith(it) == true }) {
        Column {
            HorizontalDivider(thickness = 1.5.dp, color = BorderColor)
            NavigationBar(
                containerColor = BackgroundColor
            ) {
                items.forEach { item ->
                    val selected = currentRoute == item.route

                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                modifier = Modifier.size(25.dp),
                                tint = if (selected) LightBlueColor else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                item.label,
                                style = MaterialTheme.typography.titleSmall.copy(color = if (selected) LightBlueColor else Color.DarkGray, fontSize = 16.sp)
                            )
                        },
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                navController.navigate(item.route) {
                                    popUpTo("home") { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = LightBlueColor.copy(alpha = 0.2f)
                        )
                    )
                }
            }
        }
    }
}