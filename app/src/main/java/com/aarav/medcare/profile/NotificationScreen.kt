package com.aarav.medcare.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NotificationScreen(
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    "Notifications",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    fontFamily = sora,
                    textAlign = TextAlign.Center
                )
            }, navigationIcon = {
                IconButton(
                    onClick = {
                         back()
                    }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back arrow",
                        tint = Color(0xFF4D4D4D),
                        modifier = Modifier.size(24.dp)
                    )
                }
            })
        }) {

        val notificationList = ProfileData.notificationList

//        LazyColumn(
//            modifier = Modifier.padding(it)
//        ) {
//            items(notificationList) { notification ->
//                NotificationCard(notification)
//            }
//        }

        Box(
            modifier = Modifier.fillMaxSize().padding(it)
                .padding(bottom = 80.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.empty_notification),
                    contentDescription = "empty",
                    modifier = Modifier.size(128.dp)
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    "There is nothing here",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = sora,
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    "We’ll use this space to alert you on orders and promos",
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF4D4D4D),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = sora,
                )
            }
        }
    }
}

@Composable
fun NotificationCard(
    notification: Notification
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        border = BorderStroke(1.dp, Color(0xFFA6CFD5))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Surface(
                color = Color(0xFF26408B),
                shape = CircleShape,
            ) {
                Image(
                    painter = painterResource(notification.icon),
                    contentDescription = "medicine vector",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(6.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {


                Text(
                    notification.title,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = sora,
                )

                Text(
                    notification.description,
                    fontWeight = FontWeight.W400,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF4D4D4D),
                    fontSize = 14.sp,
                    fontFamily = sora,
                )

            }
        }
    }
}