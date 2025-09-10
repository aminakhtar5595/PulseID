package com.example.digitalbusinesscard.ui.screens.contacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.R
import com.example.digitalbusinesscard.data.datastore.ContactDataStore
import com.example.digitalbusinesscard.data.model.Contact
import com.example.digitalbusinesscard.ui.components.ButtonWithIcon
import com.example.digitalbusinesscard.ui.components.ContactCard
import com.example.digitalbusinesscard.ui.components.IconTextRow
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(navController: NavController) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var addContactSheet by remember { mutableStateOf(false) }
    var contactInoSheet by remember { mutableStateOf(false) }
    var selectedContact by remember { mutableStateOf<Contact?>(null) }

    val context = LocalContext.current
    val contactDataStore = remember { ContactDataStore(context) }
    val contacts by contactDataStore.getContacts().collectAsState(initial = emptyList())

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
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        addContactSheet = true
                        scope.launch { sheetState.show() }
                    }
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

        if (contacts.isNotEmpty()) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = BackgroundColor)
            ) {
                contacts.forEach { item ->
                    ContactCard(initial = item.firstName.firstOrNull()?.toString() ?: "S", image = R.drawable.app_logo, title = item.firstName, company = item.company,
                        onClick = {
                            selectedContact = item
                            contactInoSheet = true
                            scope.launch { sheetState.show() }
                        }
                    )
                }
            }
        } else {
            noData(navController = navController)
        }

        AddContactSheet(showSheet = addContactSheet,
            sheetState = sheetState,
            onDismissRequest = { addContactSheet = false },
            navController = navController
        )

        ContactInfoSheet(showSheet = contactInoSheet,
            sheetState = sheetState,
            onDismissRequest = { contactInoSheet = false },
            navController = navController,
            contact = selectedContact
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactSheet(
    showSheet: Boolean,
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    navController: NavController
) {
    val contactItems = listOf(
        Menu(Icons.Outlined.Add, "Create new", ""),
        Menu(Icons.Outlined.Person, "Import", ""),
        Menu(Icons.Outlined.Settings, "Scan", "")
    )
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column (
                modifier = Modifier.padding(horizontal = 25.dp)
            ) {
                Row {
                    Text(
                        text = "Add Contact",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                contactItems.forEach { menu ->
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier.padding(horizontal = 10.dp).clickable { navController.navigate("add_contact/") }
                    ) {
                        Icon(
                            imageVector = menu.icon,
                            contentDescription = menu.title,
                            modifier = Modifier.size(30.dp),
                            tint = Color.Gray
                        )

                        Column {
                            Text(
                                text = menu.title,
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Light, fontSize = 20.sp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}

@Composable
fun noData(navController: NavController) {
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
        ButtonWithIcon(title = "SCAN", icon = Icons.Outlined.Settings, contentColor = LightBlueColor, onClick = { })
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
        ButtonWithIcon(title = "ADD CONTACT", icon = Icons.Outlined.Person, onClick = { navController.navigate("add_contact/") })
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Keep business and private contacts separate. Import business contacts into PulseID for a clear overview.",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Light, color = Color.DarkGray, textAlign = TextAlign.Center)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactInfoSheet(
    showSheet: Boolean,
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    navController: NavController,
    contact: Contact?
) {
    if (showSheet && contact != null) {
        val contactItems = listOf(
            Menu(Icons.Outlined.Email, if (!contact.email.isNullOrBlank()) contact.email else "No email", ""),
            Menu(Icons.Outlined.Phone, if (!contact.phone.isNullOrBlank()) contact.phone else "No phone", ""),
            Menu(Icons.Outlined.Home, if (!contact.company.isNullOrBlank()) contact.company else "No company", "")
        )
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column (
                modifier = Modifier.padding(horizontal = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.add_image), // Replace with your image
//                    contentDescription = "Profile Picture",
//                    modifier = Modifier
//                        .size(150.dp)
//                        .clip(CircleShape)
//                        .align(Alignment.CenterHorizontally)
//                )
                Text(
                    text = "${contact.firstName} ${contact.lastName}",
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
                Spacer(modifier = Modifier.height(40.dp))
                Column (
                    modifier = Modifier
                        .background(color = BorderColor, shape = RoundedCornerShape(3))
                        .fillMaxWidth()
                        .padding(top = 25.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
                ) {
                    contactItems.forEach { contact ->
                        IconTextRow(contact)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                ButtonWithIcon(title = "Open Detailed Contact", icon = Icons.Outlined.Settings, contentColor = LightBlueColor, widthFraction = 1f, onClick = { navController.navigate("contact_info/${contact.id}") })
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
    }
}