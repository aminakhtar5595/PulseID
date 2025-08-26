package com.example.digitalbusinesscard.ui.screens.contacts

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.R
import com.example.digitalbusinesscard.data.datastore.ContactDataStore
import com.example.digitalbusinesscard.data.model.Contact
import com.example.digitalbusinesscard.ui.components.InputWithIcon
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor
import kotlinx.coroutines.launch

@Composable
fun AddContactScreen(navController: NavController, contactId: String) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val contactDataStore = remember { ContactDataStore(context) }
    val scope = rememberCoroutineScope()
    val contacts by contactDataStore.getContacts().collectAsState(initial = emptyList())
    val contact = contacts.find { it.id == contactId }
    var cardType by rememberSaveable { mutableStateOf("") }
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var job by rememberSaveable { mutableStateOf("") }
    var department by rememberSaveable { mutableStateOf("") }
    var company by rememberSaveable { mutableStateOf("") }
    var website by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(contact) {
        contact?.let {
            cardType = it.cardType ?: ""
            firstName = it.firstName ?: ""
            lastName = it.lastName ?: ""
            email = it.email ?: ""
            phone = it.phone ?: ""
            job = it.job ?: ""
            department = it.department ?: ""
            company = it.company ?: ""
            website = it.website ?: ""
        }
    }
    Log.i("AddContactScreen", "Get contacts: $contact")

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back arrow icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() }
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
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_image),
                    contentDescription = "Add Contact Image",
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Person, input = cardType, placeholder = "Card Type", onInputChange = { cardType = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Person, input = firstName, placeholder = "First Name", onInputChange = { firstName = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Person, input = lastName, placeholder = "Last Name", onInputChange = { lastName = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Email, input = email, placeholder = "Email", onInputChange = { email = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Phone, input = phone, placeholder = "Phone Number", onInputChange = { phone = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Info, input = job, placeholder = "Job", onInputChange = { job = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Settings, input = department, placeholder = "Department", onInputChange = { department = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.Home, input = company, placeholder = "Company", onInputChange = { company = it })
                Spacer(modifier = Modifier.height(20.dp))

                InputWithIcon(icon = Icons.Outlined.DateRange, input = website, placeholder = "Website", onInputChange = { website = it })
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
                    modifier = Modifier.clickable {
                        scope.launch {
                            val newContact = Contact(
                                cardType = cardType,
                                firstName = firstName,
                                lastName = lastName,
                                email = email,
                                phone = phone,
                                job = job,
                                department = department,
                                company = company,
                                website = website
                            )
//                            contactDataStore.saveContact(newContact)
                            if (contact != null) {
                                contactDataStore.deleteContact(contact.id)
                            }
                            navController.popBackStack()
                        }
                    }
                )
            }
        }
    }
}
