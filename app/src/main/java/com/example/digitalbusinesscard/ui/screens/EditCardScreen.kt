package com.example.digitalbusinesscard.ui.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

        Divider(color = Color.Gray, thickness = 0.5.dp,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {

// Commenting old UI
//        OutlinedTextField(
//            value = viewModel.fullName,
//            onValueChange = { viewModel.fullName = it },
//            label = { Text("Full Name") },
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//        Spacer(
//            modifier = Modifier
//            .height(15.dp)
//        )
//
//        OutlinedTextField(
//            value = viewModel.jobTitle,
//            onValueChange = { viewModel.jobTitle = it },
//            label = { Text("Job Title") },
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//
//        Spacer(
//            modifier = Modifier
//                .height(15.dp)
//        )
//
//        OutlinedTextField(
//            value = viewModel.company,
//            onValueChange = { viewModel.company = it },
//            label = { Text("Company") },
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//
//        Spacer(
//            modifier = Modifier
//                .height(15.dp)
//        )
//
//        OutlinedTextField(
//            value = viewModel.phoneNumber,
//            onValueChange = { viewModel.phoneNumber = it },
//            label = { Text("Phone Number") },
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//
//        Spacer(
//            modifier = Modifier
//                .height(15.dp)
//        )
//
//        OutlinedTextField(
//            value = viewModel.email,
//            onValueChange = { viewModel.email = it },
//            label = { Text("Email") },
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//
//        Spacer(
//            modifier = Modifier
//                .height(15.dp)
//        )
//
//        Button(
//            onClick = { navController.popBackStack() },
//            modifier = Modifier
//                .fillMaxWidth(),
//            enabled = viewModel.isFormValid()
//            ) {
//            Text(text = "Submit")
//        }
    }
    }
}