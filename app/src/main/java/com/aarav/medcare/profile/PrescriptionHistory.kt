package com.aarav.medcare.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.components.MedicineDropDown
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PrescriptionHistory(
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
            mutableStateOf("Active Recipe")
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
                listOfValues = listOf( "Past Prescriptions",
                    "Recent Prescriptions",
                    "Oldest Prescriptions"
                ),
                Modifier.padding(16.dp)
            )

            val prescriptionList = ProfileData.prescriptions

            LazyColumn(
            ) {
                items(prescriptionList) {
                    prescription -> PrescriptionRecipe(prescription)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrescriptionRecipe(
    prescription: Prescription
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color(0xFF26408B))
            ) {
                Row(
                    modifier = Modifier.padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Doctor's Name: ",
                        fontFamily = sora,
                        color = Color.White,
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp
                    )
                    Text(
                        prescription.doctorName,
                        fontFamily = sora,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
            }

            prescription.medicineInfo.forEachIndexed {
                index, medicine ->

                val count = prescription.medicineInfo.size
                PrescriptionItem(medicine)
                if(index < count - 1) {
                    HorizontalDivider()
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color(0xFFE3E3E3))
                    .padding(4.dp)
                ,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    prescription.date,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D),
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrescriptionItem(
    medicineInfo: Pair<String, String>,
) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(24.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                medicineInfo.first,
                fontFamily = sora,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                medicineInfo.second,
                    fontFamily = sora,
                color = Color(0xFF4D4D4D),
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )
        }
    }
}