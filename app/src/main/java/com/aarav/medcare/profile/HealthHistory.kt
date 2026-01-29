package com.aarav.medcare.profile

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.components.MedicineDropDown
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HealthHistory(
    back: () -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Prescription History",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        fontFamily = sora,
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
                            tint = Color(0xFF4D4D4D),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) {

        var selectedItem by remember {
            mutableStateOf("Disease History")
        }

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            MedicineDropDown(
                selectedValue = selectedItem,
                trailingText = "",
                placeholder = "",
                onValueSelected = { selectedItem = it },
                listOfValues = listOf(
                    "Allergy History",
                    "Surgery History",
                    "History of Drugs Consumed"
                ),
                Modifier.padding(16.dp)
            )
            
            val healthHistoryList = ProfileData.healthHistoryList

            LazyColumn() {
                items(healthHistoryList) {
                    item -> HistoryItem(item)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryItem(
    healthHistory: HealthHistory
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))

    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    healthHistory.prescription,
                    fontFamily = sora,
                    color = Color(0xFF26408B),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF4D4D4D)
                ) {
                    Text(
                        healthHistory.tag,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = sora,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(
                healthHistory.title,
                fontFamily = sora,
                color = Color(0xFF8F8F8F),
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )

            Spacer(Modifier.height(8.dp))

            healthHistory.description?.let {
                Text(
                    it,
                    fontFamily = sora,
                    color = Color(0xFF8F8F8F),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(8.dp))
            }

            Text(
                "Check Details",
                fontFamily = sora,
                textDecoration = TextDecoration.Underline,
                color = Color(0xFF26408B),
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )
        }
    }
}