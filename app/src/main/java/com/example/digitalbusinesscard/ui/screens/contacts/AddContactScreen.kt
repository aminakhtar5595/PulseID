package com.example.digitalbusinesscard.ui.screens.contacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.R
import com.example.digitalbusinesscard.ui.components.InputWithIcon
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor

@Composable
fun AddContactScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var job by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var website by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(top = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back arrow icon",
                    modifier = Modifier.size(30.dp).clickable { navController.popBackStack() }
                )
                Text(
                    text = "Edit Contact",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(thickness = 1.5.dp, color = BorderColor)
            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(scrollState).padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_image),
                    contentDescription = "Add Contact Image",
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Person, input = firstName, placeholder = "First Name")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Person, input = lastName, placeholder = "Last Name")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Email, input = email, placeholder = "Email")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Phone, input = phone, placeholder = "Phone Number")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Info, input = job, placeholder = "Job")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Settings, input = department, placeholder = "Department")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Home, input = company, placeholder = "Company")
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.DateRange, input = website, placeholder = "Website")
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(color = BackgroundColor)
        ) {
            HorizontalDivider(thickness = 1.5.dp, color = BorderColor)
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "CANCEL",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.clickable { navController.popBackStack() }
                )

                Text(
                    text = "|",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "SAVE",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.clickable { navController.popBackStack() }
                )
            }
        }
    }
}
