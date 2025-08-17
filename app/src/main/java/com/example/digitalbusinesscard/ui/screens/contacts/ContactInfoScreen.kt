package com.example.digitalbusinesscard.ui.screens.contacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.R
import com.example.digitalbusinesscard.ui.components.ButtonWithIcon
import com.example.digitalbusinesscard.ui.components.IconTextRow
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun ContactInfoScreen(navController: NavController) {
    val contactItems = listOf(
        Menu(Icons.Outlined.List, "test@gmail.com", "Work"),
        Menu(Icons.Outlined.Person, "+92333 2480781", "Work"),
        Menu(Icons.Outlined.Person, "Senior Software Engineer", ""),
        Menu(Icons.Outlined.Person, "Technology", ""),
        Menu(Icons.Outlined.Person, "Webook", ""),
        Menu(Icons.Outlined.Person, "www.webook.com", ""),
        Menu(Icons.Outlined.Person, "Tap to add note", ""),
        Menu(Icons.Outlined.Person, "Added 22 Jul 2025", "")
    )
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier.fillMaxSize().background(color = BackgroundColor).padding(20.dp).verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back Arrow",
                modifier = Modifier.size(30.dp).clickable { navController.popBackStack() }
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit Contact",
                    modifier = Modifier.size(30.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "Favorite Contact",
                    modifier = Modifier.size(30.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "More Options",
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.add_image),
                contentDescription = "Contact Image",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Amin Akhtar",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_icon),
                    contentDescription = "WhatsApp Icon"
                )
                Image(
                    painter = painterResource(id = R.drawable.message_icon),
                    contentDescription = "Message Icon"
                )
                Image(
                    painter = painterResource(id = R.drawable.email_icon),
                    contentDescription = "Email Icon"
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Column (
            modifier = Modifier.background(color = BorderColor, shape = RoundedCornerShape(3)).fillMaxWidth().padding(top = 25.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
        ) {
            Text(
                text = "Contact Info",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            contactItems.subList(0, 6).forEach { contact ->
                IconTextRow(contact)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column (
            modifier = Modifier.background(color = BorderColor, shape = RoundedCornerShape(3)).fillMaxWidth().padding(top = 25.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
        ) {
            Text(
                text = "Extra Info",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            contactItems.subList(6, 8).forEach { contact ->
                IconTextRow(contact)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        ButtonWithIcon(title = "Save to contacts", icon = Icons.Outlined.Settings, contentColor = LightBlueColor, widthFraction = 1f, onClick = { navController.popBackStack() })
    }
}
