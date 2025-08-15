package com.example.digitalbusinesscard.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digitalbusinesscard.ui.model.BottomNavItem

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Card", "home", Icons.Outlined.DateRange),
        BottomNavItem("Contacts", "habits", Icons.Outlined.AccountBox),
        BottomNavItem("Premium", "tasks", Icons.Outlined.Lock),
        BottomNavItem("Menu", "category", Icons.Outlined.Face)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute != "category" && currentRoute != "create_task" && currentRoute != "habit_flow" && currentRoute != "splash") {
        NavigationBar(
            containerColor = Color.White
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    label = { Text(item.label, style = MaterialTheme.typography.titleSmall.copy(color = if (selected) Color(0xFFc03755) else Color(0xFFa2a2a2))) },
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
                        indicatorColor = Color(0xFFc03755)
                    )
                )
            }
        }
    }
}