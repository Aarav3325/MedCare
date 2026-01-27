package com.aarav.medcare.services.hospital

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.components.SearchBarShopping
import com.aarav.medcare.services.HospitalInfo
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HospitalListScreen(
    back: () -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                expandedHeight = 58.dp,
                title = {
                    SearchBarShopping(expanded) {
                        expanded = !expanded
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            back()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "back arrow",
                            tint = Color(0xFF4D4D4D),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            SearchProvinces()

            Spacer(Modifier.height(4.dp))

            val hospitalList = ServiceData.hospitalInfoList

            LazyColumn() {
                items(hospitalList) {
                    hospital ->
                    HospitalInfoCard(hospital)
                }
            }
        }
    }
}

@Composable
fun SearchProvinces() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .border(
                androidx.compose.foundation.BorderStroke(1.dp, color = Color(0xFFE3E3E3)),
                shape = RoundedCornerShape(6.dp)
            )
            .height(52.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Search Provinces",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color(0xFF26408B),
            fontFamily = sora
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(24.dp),
            contentDescription = "down icon",
            tint = Color(0xFF4D4D4D)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HospitalInfoCard(
    hospitalInfo: HospitalInfo
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(bottom = 12.dp, start = 16.dp , end = 16.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Image(
                        painter = painterResource(hospitalInfo.image),
                        contentDescription = "product image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 90.dp, height = 68.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        hospitalInfo.name,
                        fontFamily = sora,
                        maxLines = 1,
                        style = TextStyle(
                            lineHeight = 15.sp
                        ),
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(
                        hospitalInfo.address,
                        fontFamily = sora,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF8F8F8F)
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
                            hospitalInfo.telephone,
                            fontFamily = sora,
                            maxLines = 1,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF26408B)
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            HorizontalDivider()

            Spacer(Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                FilledTonalButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .height(38.dp)
                        .weight(1f),
                    border = BorderStroke(1.dp, Color(0xFF26408B)),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        "Bed Detail",
                        fontSize = 14.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold
                    )
                }


                FilledTonalButton(
                    onClick = {},
                    modifier = Modifier
                        .height(38.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        // containerColor = Color.Transparent,
                        containerColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        "Location",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "right arrow",
                        tint = Color.White
                    )
                }
            }
        }
    }
}