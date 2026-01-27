package com.aarav.medcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aarav.medcare.home.ServiceItem
import com.aarav.medcare.services.chatdoctor.TimeCard
import com.aarav.medcare.ui.theme.sora

@Composable
fun ServicesGrid(
    serviceList: List<ServiceItem>,
    navController: NavController? = null
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 4),
        modifier = Modifier
            .padding(8.dp)
            .height(202.dp),
    ) {
        items(
            serviceList
        ) { service ->
            ServiceItemLayout(service) {
                service.route?.let {
                    navController?.navigate(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceItemLayout(
    serviceItem: ServiceItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(82.dp)
            .shadow(4.dp, RectangleShape)
            .clickable(
                indication = null,
                interactionSource = null
            ) {
                onClick()
            },
        //.size(width = 104.dp, height = 92.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(serviceItem.icon),
                    contentDescription = "service icon",
                    modifier = Modifier.size(36.dp)
                )

                Text(
                    text = serviceItem.name,
                    maxLines = 2,
                    color = Color(0xFF26408B),
                    fontFamily = sora,
                    style = TextStyle(
                        lineHeight = 15.sp
                    ),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
fun WorkingHoursGrid(
    timingsList: List<String>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 4),
        modifier = Modifier.heightIn(min = 98.dp, max = 200.dp)
    ) {
        items(
            timingsList
        ) { time ->
            TimeCard(time)
        }
    }
}