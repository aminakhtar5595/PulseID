package com.example.digitalbusinesscard.ui.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.digitalbusinesscard.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
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
                onClick = {  },
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
}