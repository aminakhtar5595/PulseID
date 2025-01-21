package com.example.digitalbusinesscard.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.ui.viewmodels.BusinessCardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCardScreen (navController: NavController, viewModel: BusinessCardViewModel) {
    Column (
        modifier = Modifier
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = viewModel.fullName,
            onValueChange = { viewModel.fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
            .height(10.dp)
        )

        OutlinedTextField(
            value = viewModel.jobTitle,
            onValueChange = { viewModel.jobTitle = it },
            label = { Text("Job Title") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        OutlinedTextField(
            value = viewModel.company,
            onValueChange = { viewModel.company = it },
            label = { Text("Company") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        OutlinedTextField(
            value = viewModel.phoneNumber,
            onValueChange = { viewModel.phoneNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Button(
            onClick = { navController.navigate("homeScreen") },
            modifier = Modifier
                .fillMaxWidth()
            ) {
            Text(text = "Submit")
        }
    }
}