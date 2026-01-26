package com.aarav.medcare.services.chatdoctor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aarav.medcare.R
import com.aarav.medcare.components.SearchBarChatDoctor
import com.aarav.medcare.home.Article
import com.aarav.medcare.home.Doctor
import com.aarav.medcare.navigation.NavRoute
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ChatDoctorScreen(
    back: () -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Chat Doctor",
                        fontFamily = sora,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        modifier = Modifier.height(24.dp),
                        textAlign = TextAlign.Center
                    )
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
                            modifier = Modifier.size(24.dp)
                        )
                    }

                }
            )
        }
    ) {

        var isExpanded by remember {
            mutableStateOf(false)
        }

        val doctorList = ServiceData.doctorList

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            SearchBarChatDoctor(
                isExpanded
            ) {
                isExpanded = !isExpanded
            }

            LazyColumn(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(doctorList) {
                    doctor -> DoctorInfo(doctor, navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DoctorInfo(doctor: Doctor, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable{
                navController.navigate(NavRoute.DoctorDetail.path)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.size(68.dp)
        ){
            Image(
                painter = painterResource(doctor.image),
                contentDescription = "doctor image",
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp).weight(0.1f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                doctor.name,
                fontWeight = FontWeight.SemiBold,
                fontFamily = sora,
                color = Color(0xFF4D4D4D),
                fontSize = 14.sp
            )

            Row {
                Text(
                    "${doctor.type} ",
                    fontWeight = FontWeight.W400,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D),
                    fontSize = 10.sp
                )

                Text(
                    " · ",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D),
                    fontSize = 10.sp
                )

                Text(
                    " ${doctor.experience}",
                    fontWeight = FontWeight.W400,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D),
                    fontSize = 10.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.
                background(Color(0xFFDCFFDD))
            ) {
                Text(
                    doctor.available ?: "Available on Wed - Sat",
                    fontWeight = FontWeight.W400,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D),
                    fontSize = 10.sp,
                    modifier = Modifier.wrapContentHeight().padding(horizontal = 4.dp)
                )
            }
        }

        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "arrow right",
                tint = Color(0xFF4D4D4D),
                modifier = Modifier.padding(start = 4.dp).size(24.dp)
            )
        }
    }
}