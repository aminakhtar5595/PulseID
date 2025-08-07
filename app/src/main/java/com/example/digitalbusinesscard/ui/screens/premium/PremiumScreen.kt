package com.example.digitalbusinesscard.ui.screens.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalbusinesscard.ui.components.IconTextRow
import com.example.digitalbusinesscard.ui.components.Subscription
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun PremiumScreen() {
    val scrollState = rememberScrollState()
    val premiumItems = listOf(
        Menu(Icons.Outlined.List, "2 weeks free testing", "With first subscription"),
        Menu(Icons.Outlined.Person, "Add-free", ""),
        Menu(Icons.Outlined.Share, "Unlimited business card scans", ""),
        Menu(Icons.Outlined.DateRange, "Card Homescreen Widget", "")
    )
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(20.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back arrow icon",
                modifier = Modifier.size(30.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Setting icon",
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column (
            modifier = Modifier.padding(horizontal = 12.dp).verticalScroll(scrollState)
        ) {
            Text(
                text = "Network on a new level",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Present yourself professionally and get the most out of your digital business card",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Light, color = Color.Gray, fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                premiumItems.forEach { menu ->
                    IconTextRow(menu, iconColor = LightBlueColor)
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
            Subscription(title = "Rs 1,750.00 / Month", description = "Monthly Subscription", icon = Icons.Outlined.CheckCircle)
            Spacer(modifier = Modifier.height(10.dp))
            Subscription(title = "Rs 10,100.00 / Year", description = "Annual Subscription", icon = Icons.Outlined.Check)
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {  },
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = LightBlueColor),
            ) {
                Text("Test now for free",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Then Rs 1,750 / Month. The plans are automatically renewed. Cancelable anytime. By clicking on \"Test now for free\" or \"Subscribe now\" you agree to our Subscription conditions",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Light, textAlign = TextAlign.Center)
            )
        }
    }
}