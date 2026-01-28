package com.aarav.medcare.services.hospital

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.components.ServicesGrid
import com.aarav.medcare.home.HomeGridData
import com.aarav.medcare.services.RoomType
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HospitalDetailScreen(
    back: () -> Unit,
    navigateToMap: () -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = back
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "arrow"
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 82.dp)
            ) {

                Header()


                HorizontalDivider(Modifier.padding(horizontal = 16.dp))

                Text(
                    "Specialties",
                    fontSize = 16.sp,
                    fontFamily = sora,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    fontWeight = FontWeight.SemiBold
                )

                val servicesList = HomeGridData.serviceList

                ServicesGrid(servicesList)


                HorizontalDivider(Modifier.padding(horizontal = 16.dp, vertical = 4.dp))

                Text(
                    "Type Rooms",
                    fontSize = 16.sp,
                    fontFamily = sora,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    fontWeight = FontWeight.SemiBold
                )

                val roomList = ServiceData.roomType

                roomList.forEach { room ->
                    RoomTypeCard(room)
                }

            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                FilledTonalButton(
                    onClick = {
                        navigateToMap()
                    },
                    modifier = Modifier
                        .height(52.dp)
                        .weight(1f),
                    border = BorderStroke(1.dp, Color(0xFF26408B)),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        "Maps",
                        fontSize = 16.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold
                    )
                }


                FilledTonalButton(
                    onClick = {},
                    modifier = Modifier
                        .height(52.dp)
                        .weight(2f),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        // containerColor = Color.Transparent,
                        containerColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        "Contact Now",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Header() {
    Column(
        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Surface(
        ) {
            Image(
                painter = painterResource(R.drawable.hospital_detail_image),
                contentDescription = "hospital image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
        }

        Spacer(Modifier.height(4.dp))

        Text(
            "Ospedale San Raffaele",
            fontSize = 16.sp,
            fontFamily = sora,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            fontSize = 14.sp,
            fontFamily = sora,
            fontWeight = FontWeight.W400,
            color = Color(0xFF4D4D4D)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.phone),
                contentDescription = "phone vector",
                modifier = Modifier.size(12.dp)
            )

            Text(
                "(+22) 2361 6257 1726",
                fontFamily = sora,
                maxLines = 1,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF26408B)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoomTypeCard(
    roomType: RoomType
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    roomType.type,
                    fontFamily = sora,
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF26408B)
                )

                roomType.supporting?.let {
                    Text(
                        it,
                        fontFamily = sora,
                        maxLines = 1,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF4D4D4D)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            DetailRowRoom("Total Beds: ", roomType.beds.toString())

            Spacer(Modifier.height(8.dp))
            DetailRowRoom("Remaining Availability: ", "${roomType.remaining} beds")

            Spacer(Modifier.height(8.dp))
            DetailRowRoom("Price per night: ", roomType.price)

        }
    }
}

@Composable
fun DetailRowRoom(
    title: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            title,
            fontFamily = sora,
            maxLines = 1,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            color = Color(0xFF4D4D4D)
        )

        Text(
            value,
            fontFamily = sora,
            maxLines = 1,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4D4D4D)
        )
    }
}