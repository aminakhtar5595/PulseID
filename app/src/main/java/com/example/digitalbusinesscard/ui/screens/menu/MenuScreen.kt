package com.example.digitalbusinesscard.ui.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.text.style.TextAlign
import com.example.digitalbusinesscard.ui.components.IconTextRow
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.BorderColor

@Composable
fun MenuScreen() {
    val scrollState = rememberScrollState()
    val menuItems = listOf(
        Menu(Icons.Outlined.List, "CARD LIST", "List of your current business cards"),
        Menu(Icons.Outlined.Person, "GIVE FEEDBACK", "Anonymous feedback to improve the app"),
        Menu(Icons.Outlined.Share, "HELP", "Visit our help section or contact us"),
        Menu(Icons.Outlined.DateRange, "NEW APP FEATURES", "Show the last changes in the app"),
        Menu(Icons.Outlined.CheckCircle, "LANGUAGE", "System Language"),
        Menu(Icons.Outlined.Place, "RECONNECT WITH PREMIUM", "If the app doest not show your Premium subscription, use this button to verify"),
        Menu(Icons.Outlined.AccountBox, "ENABLE BIG QR CODE", "Tap on the QR code to show it bigger"),
        Menu(Icons.Outlined.Email, "ENABLE 3D EFFECT", "Titling is not supported by your device"),
        Menu(Icons.Outlined.Lock, "CONFIRM QR CODE IMPORT", "Ask before importing QR codes during card scanning"),
        Menu(Icons.Outlined.Settings, "LOGIN", "Login with company account"),
        Menu(Icons.Outlined.List, "APP PAGE", "App Page on Google Play"),
        Menu(Icons.Outlined.Person, "DEVELOPER PAGE", "Developer Page on Google Play"),
        Menu(Icons.Outlined.Share, "APP INFO", "App Settings"),
        Menu(Icons.Outlined.DateRange, "APP NOTIFICATIONS", "Notification Settings"),
        Menu(Icons.Outlined.CheckCircle, "MORE INFO", "Information and Licenses")
    )
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(vertical = 20.dp)
    ) {
        Text(
            text = "Menu",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.W500), modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.5.dp, color = BorderColor)

        Spacer(modifier = Modifier.height(20.dp))

        Column (
            modifier = Modifier.padding(horizontal = 20.dp).verticalScroll(scrollState)
        ) {
            Text(
                text = "GENERAL",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(20.dp))

            menuItems.subList(0, 6).forEach { menu ->
                IconTextRow(menu)
                Spacer(modifier = Modifier.height(30.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = BorderColor)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "CUSTOMIZE YOUR BEHAVIOUR",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            menuItems.subList(6, 9).forEach { menu ->
                IconTextRow(menu)
                Spacer(modifier = Modifier.height(30.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = BorderColor)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "COMPANY ACCOUNT",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            menuItems.subList(9, 10).forEach { menu ->
                IconTextRow(menu)
                Spacer(modifier = Modifier.height(30.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = BorderColor)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "GOOGLE ACCOUNT",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            menuItems.subList(10, 12).forEach { menu ->
                IconTextRow(menu)
                Spacer(modifier = Modifier.height(30.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = BorderColor)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "INFORMATION",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            menuItems.subList(12, 15).forEach { menu ->
                IconTextRow(menu)
                Spacer(modifier = Modifier.height(30.dp))
            }

        }
    }
}