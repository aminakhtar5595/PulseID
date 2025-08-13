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
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.digitalbusinesscard.ui.components.ContactCard
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.BorderColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var addContactSheet by remember { mutableStateOf(false) }
    var isData by remember { mutableStateOf(true) }
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

        if (isData) {
            Column (
                modifier = Modifier.fillMaxSize().background(color = BackgroundColor)
            ) {
                ContactCard(initial = "A", image = R.drawable.app_logo, title = "Amin Akhtar", company = "Webook")
                ContactCard(initial = "S", image = R.drawable.app_logo, title = "Saim Akhtar", company = "CVSparkle")
            }
        } else {
            noData()
        }

        AddContactSheet(showSheet = addContactSheet,
            sheetState = sheetState,
            onDismissRequest = { addContactSheet = false })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactSheet(
    showSheet: Boolean,
    sheetState: SheetState,
    onDismissRequest: () -> Unit
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
                        modifier = Modifier.padding(horizontal = 10.dp)
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
fun noData() {
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
