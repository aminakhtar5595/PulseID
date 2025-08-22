package com.example.digitalbusinesscard.ui.screens.premium

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.ui.components.IconTextRow
import com.example.digitalbusinesscard.ui.components.InputWithIcon
import com.example.digitalbusinesscard.ui.components.Subscription
import com.example.digitalbusinesscard.ui.model.Menu
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PremiumScreen(navController: NavController) {
    val premiumItems = listOf(
        Menu(Icons.Outlined.CheckCircle, "2 weeks free testing", "With first subscription"),
        Menu(Icons.Outlined.CheckCircle, "Add-free", ""),
    )
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var contactFormSheet by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(horizontal = 20.dp)
    ) {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back arrow icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() }
                )
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Setting icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            contactFormSheet = true
                            scope.launch { sheetState.show() }
                        }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column (
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Network on a new level",
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Present yourself professionally and get the most out of your digital business card",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray, fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                premiumItems.forEach { menu ->
                    IconTextRow(menu, iconColor = LightBlueColor, descriptionFontSize = 16.sp)
                    Spacer(modifier = Modifier.height(25.dp))
                }
            }
            }
        }

        Column (
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
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
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium, fontSize = 18.sp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Then Rs 1,750 / Month. The plans are automatically renewed. Cancelable anytime. By clicking on \"Test now for free\" or \"Subscribe now\" you agree to our Subscription conditions",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light, textAlign = TextAlign.Center)
            )
        }

        ContactFormSheet(showSheet = contactFormSheet,
            sheetState = sheetState,
            onDismissRequest = { contactFormSheet = false })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactFormSheet(
    showSheet: Boolean,
    sheetState: SheetState,
    onDismissRequest: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val isFormValid = name.isNotBlank() && email.isNotBlank() && message.isNotBlank()
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            dragHandle = null,
            tonalElevation = 0.dp,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column (
                modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 30.dp, bottom = 10.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Contact Form",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close form icon",
                        modifier = Modifier.size(25.dp).clickable { onDismissRequest() }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                InputWithIcon(icon = Icons.Outlined.Person, input = name, placeholder = "Name", onInputChange = { name = it })
                Spacer(modifier = Modifier.height(10.dp))
                InputWithIcon(icon = Icons.Outlined.Email, input = email, placeholder = "Email", onInputChange = { email = it })
                Spacer(modifier = Modifier.height(10.dp))
                InputWithIcon(icon = Icons.Outlined.Home, input = message, placeholder = "Message", onInputChange = { message = it })
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            submitContactForm(name, email, message)
                            Toast.makeText(context, "Thanks for reporting your problem!", Toast.LENGTH_SHORT).show()
                            sheetState.hide()
                            onDismissRequest()
                        }
                    },
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues(vertical = 15.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = LightBlueColor),
                    enabled = isFormValid
                ) {
                    Text("Send",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W400)
                    )
                }
            }
        }
    }
}

fun submitContactForm(name: String, email: String, message: String) {
    Log.d("Submit contact form", "Name = $name")
    Log.d("Submit contact form", "Email = $email")
    Log.d("Submit contact form", "Message = $message")
}