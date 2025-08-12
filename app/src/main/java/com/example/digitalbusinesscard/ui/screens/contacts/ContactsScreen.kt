package com.example.digitalbusinesscard.ui.screens.contacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalbusinesscard.R
import com.example.digitalbusinesscard.ui.components.ButtonWithIcon
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor

@Composable
fun ContactsScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Contacts",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.W500)
            )
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add contact icon",
                modifier = Modifier.size(30.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "0/5 monthly scans. ",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Light)
            )
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    contentColor = LightBlueColor,
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    "Need more help?",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
            }
        }
        HorizontalDivider(thickness = 1.5.dp, color = BorderColor)

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.contacts_icon),
                contentDescription = "Contact image",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonWithIcon(title = "SCAN", icon = Icons.Outlined.Settings, contentColor = LightBlueColor)
            Spacer(modifier = Modifier.height(15.dp))

            BoxWithConstraints {
                val dividerWidth = maxWidth * 0.2f

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HorizontalDivider(
                        thickness = 1.5.dp,
                        color = Color.LightGray,
                        modifier = Modifier.width(dividerWidth)
                    )
                    Text(
                        text = "Or",
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray, fontSize = 18.sp), modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    HorizontalDivider(
                        thickness = 1.5.dp,
                        color = Color.LightGray,
                        modifier = Modifier.width(dividerWidth)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            ButtonWithIcon(title = "ADD CONTACT", icon = Icons.Outlined.Person)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Keep business and private contacts separate. Import business contacts into PulseID for a clear overview.",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Light, color = Color.DarkGray, textAlign = TextAlign.Center)
            )
        }
    }
}