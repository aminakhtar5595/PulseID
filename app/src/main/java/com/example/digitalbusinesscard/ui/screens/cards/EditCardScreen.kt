package com.example.digitalbusinesscard.ui.screens.cards
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.ui.viewmodels.BusinessCardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCardScreen (navController: NavController, viewModel: BusinessCardViewModel) {
    Column (
        modifier = Modifier
            .padding(vertical = 20.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, start = 20.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .size(23.dp)
                    .clickable { navController.popBackStack() },
            )
            Text(
                text = "Add new Card",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Divider(color = Color.Gray, thickness = 0.5.dp)

//        Column (
//            modifier = Modifier
//                .padding(horizontal = 20.dp, vertical = 20.dp)
//        ) {
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 20.dp)
//            ) {
//                Icon(imageVector = Icons.Filled.Person, contentDescription = "First Name",
//                    modifier = Modifier.padding(end = 15.dp))
//
//                TextField(
//                    value = viewModel.fullName,
//                    onValueChange = { viewModel.fullName = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        textColor = Color.Gray,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        placeholderColor = Color.LightGray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(width = 0.5.dp, color = Color.LightGray),
//                    placeholder = { Text("First Name") },
//                )
//            }
//
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 20.dp)
//            ) {
//                Icon(imageVector = Icons.Filled.Person, contentDescription = "Last Name",
//                    modifier = Modifier.padding(end = 15.dp))
//
//                TextField(
//                    value = viewModel.fullName,
//                    onValueChange = { viewModel.fullName = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        textColor = Color.Gray,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        placeholderColor = Color.LightGray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(width = 0.5.dp, color = Color.LightGray),
//                    placeholder = { Text("Last Name") },
//                )
//            }
//
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 20.dp)
//            ) {
//                Icon(imageVector = Icons.Filled.Phone, contentDescription = "Phone Number",
//                    modifier = Modifier.padding(end = 15.dp))
//
//                TextField(
//                    value = viewModel.phoneNumber,
//                    onValueChange = { viewModel.phoneNumber = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        textColor = Color.Gray,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        placeholderColor = Color.LightGray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(width = 0.5.dp, color = Color.LightGray),
//                    placeholder = { Text("Phone Number") },
//                )
//            }
//
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 20.dp)
//            ) {
//                Icon(imageVector = Icons.Filled.MailOutline, contentDescription = "Email",
//                    modifier = Modifier.padding(end = 15.dp))
//
//                TextField(
//                    value = viewModel.email,
//                    onValueChange = { viewModel.email = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        textColor = Color.Gray,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        placeholderColor = Color.LightGray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(width = 0.5.dp, color = Color.LightGray),
//                    placeholder = { Text("Email") },
//                )
//            }
//
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 20.dp)
//            ) {
//                Icon(imageVector = Icons.Filled.Lock, contentDescription = "Job",
//                    modifier = Modifier.padding(end = 15.dp))
//
//                TextField(
//                    value = viewModel.jobTitle,
//                    onValueChange = { viewModel.jobTitle = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        textColor = Color.Gray,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        placeholderColor = Color.LightGray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(width = 0.5.dp, color = Color.LightGray),
//                    placeholder = { Text("Job") },
//                )
//            }
//
//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 20.dp)
//            ) {
//                Icon(imageVector = Icons.Filled.Info, contentDescription = "Company",
//                    modifier = Modifier.padding(end = 15.dp))
//
//                TextField(
//                    value = viewModel.company,
//                    onValueChange = { viewModel.company = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        textColor = Color.Gray,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        placeholderColor = Color.LightGray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(width = 0.5.dp, color = Color.LightGray),
//                    placeholder = { Text("Company") },
//                )
//            }
//
//            Button(
//                onClick = {  },
//                modifier = Modifier
//                    .fillMaxWidth(),
//                shape = RoundedCornerShape(5.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
//            ) {
//                Text(text = "SAVE")
//            }
//
//        }
    }
}