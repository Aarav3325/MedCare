package com.aarav.medcare.services.hospital

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HospitalMapScreen() {
    Scaffold(
        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                },
//                navigationIcon = {
//                    IconButton(
//                        onClick = {
//                            //back()
//                        }
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.KeyboardArrowLeft,
//                            contentDescription = "back arrow",
//                            tint = Color(0xFF4D4D4D),
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//                }
//            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.maps),
                contentDescription = "maps",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )


            HospitalInfoCard(
                Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp),
                hospitalInfo = ServiceData.hospitalInfoList.get(0),
                navigateToDetail = {},
                navigateToMap = {}
            )
        }

    }
}