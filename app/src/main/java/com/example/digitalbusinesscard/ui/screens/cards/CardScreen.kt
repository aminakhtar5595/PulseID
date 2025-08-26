package com.example.digitalbusinesscard.ui.screens.cards
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.digitalbusinesscard.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.data.datastore.CardDataStore
import com.example.digitalbusinesscard.data.model.Card
import com.example.digitalbusinesscard.ui.components.ButtonWithIcon
import com.example.digitalbusinesscard.ui.components.PageIndicator
import com.example.digitalbusinesscard.ui.theme.BackgroundColor
import com.example.digitalbusinesscard.ui.theme.LightBlueColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun CardScreen(navController: NavController) {
    val context = LocalContext.current
    val cardDataStore = remember { CardDataStore(context) }
    val cards by cardDataStore.getCards().collectAsState(initial = emptyList())
    Log.i("HomeScreen", "Get cards: ${cards.size}")

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(vertical = 20.dp)
    ) {
        if (cards.isNotEmpty()) {
            CardView(navController = navController, cards = cards)
        } else {
            NoData(navController = navController)
        }
    }
}

@Composable
fun NoData(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cards_icon),
            contentDescription = "Contact image",
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonWithIcon(title = "CREATE BUSINESS CARD", icon = Icons.Outlined.Settings, contentColor = LightBlueColor, widthFraction = 0.9f, onClick = { navController.navigate("add_card") })
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
        ButtonWithIcon(title = "CONTACTS", icon = Icons.Outlined.Person, widthFraction = 0.9f, onClick = { navController.navigate("contacts") })
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CardView(navController: NavController, cards: List<Card>) {
    val pagerState = rememberPagerState(initialPage = 0)
    val currentPage = pagerState.currentPage
    val totalPages = cards.size + 1

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = "More options",
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalPager(
            count = totalPages,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) { page ->
            if (page < cards.size) {
                BusinessCardView(card = cards[page])
            } else {
                CardSecondView(navController = navController)
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PageIndicator(currentPage = currentPage, totalPages = totalPages)
        }
    }
}

@Composable
fun BusinessCardView(card: Card) {
    Box(
        modifier = Modifier
            .padding(horizontal = 25.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.add_image),
//                contentDescription = "User profile picture",
//                modifier = Modifier.size(120.dp)
//            )
//
//            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = card.firstName,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            if (card.lastName.isNotBlank()) {
                Text(
                    text = card.lastName,
                    style = MaterialTheme.typography.headlineMedium
                )
            }


            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(0.3f)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Image(
                painter = painterResource(id = R.drawable.qr_image),
                contentDescription = "User QR code",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}

@Composable
fun CardSecondView(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.new_card),
            contentDescription = "Second profile picture",
            modifier = Modifier.size(170.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        ButtonWithIcon(title = "ADD NEW CARD", icon = Icons.Outlined.Add, contentColor = LightBlueColor, onClick = { navController.navigate("add_card") })
    }
}