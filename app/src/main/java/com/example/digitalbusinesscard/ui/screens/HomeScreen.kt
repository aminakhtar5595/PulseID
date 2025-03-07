package com.example.digitalbusinesscard.ui.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.digitalbusinesscard.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .padding(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Menu",
            modifier = Modifier
                .size(25.dp)
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_icon),
                contentDescription = "Home Icon",
                modifier = Modifier
                    .size(250.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { showDialog = true },
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(horizontal = 23.dp, vertical = 18.dp),
                border = BorderStroke(0.5.dp, Color.LightGray),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Black, containerColor = Color.Transparent),
            ) {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = "Create Card",
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = "CREATE CARD",
                    modifier = Modifier
                        .padding(start = 10.dp),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
        }
    }

    if (showDialog) {
        dialogView(
            dismiss = { showDialog = false },
        )
    }
}

@Composable
fun dialogView(dismiss: () -> Unit ) {
    Dialog(onDismissRequest = { dismiss() }) {
        Box (
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 24.dp)
        ) {
            Column {
                Text(text = "No cards available",
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.W400),
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                )

                Text(text = "There are currently no cards to share. Please create a digital business card.",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier.padding(bottom = 30.dp))

                Button(
                    onClick = { dismiss() },
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 15.dp),
                    border = BorderStroke(0.5.dp, Color.LightGray),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Black, containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Create Card",
                        modifier = Modifier
                            .size(18.dp)
                    )
                    Text(
                        text = "CREATE CARD",
                        modifier = Modifier
                            .padding(start = 10.dp),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }

    }
}
