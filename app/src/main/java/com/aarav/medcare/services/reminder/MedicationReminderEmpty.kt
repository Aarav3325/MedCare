package com.aarav.medcare.services.reminder

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.services.chatdoctor.ScheduleRow
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MedicationReminderEmpty(
    back: () -> Unit,
    navigateToAddMedicine: () -> Unit
) {

    val schedule = ServiceData.schedule

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Medication Reminder",
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column {
                MonthRow()

                ScheduleRow(schedule)

                Spacer(Modifier.height(24.dp))

                Text(
                    "Today, 20 February 2024",
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF4D4D4D),
                    fontSize = 16.sp,
                    fontFamily = sora,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )


                MedicineReminderCard()
            }

//            EmptyState(
//                Modifier
//                    .align(Alignment.Center)
//            )


            FilledTonalButton(
                onClick = {
                    navigateToAddMedicine()
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(52.dp)
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Add Medicine",
                    fontSize = 16.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MonthRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "back arrow",
            tint = Color(0xFF4D4D4D)
        )

        Text(
            "February",
            fontWeight = FontWeight.W400,
            color = Color(0xFF4D4D4D),
            fontSize = 16.sp,
            fontFamily = sora,
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "back arrow",
            tint = Color(0xFF4D4D4D)
        )
    }
}

@Composable
fun EmptyState(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.medicine_empty_2),
            contentDescription = "empty",
            modifier = Modifier.size(128.dp)
        )

        Text(
            "No medication scheduled for today",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = sora,
        )

        Spacer(Modifier.height(8.dp))

        Text(
            "Click add medicine below to add a schedule",
            fontWeight = FontWeight.Normal,
            color = Color(0xFF4D4D4D),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontFamily = sora,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MedicineReminderCard() {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(12.dp)
        ) {
            Surface(
                color = Color(0xFFA6CFD5),
                shape = CircleShape,
            ) {
                Image(
                    painter = painterResource(R.drawable.medicine),
                    contentDescription = "medicine vector",
                    modifier = Modifier.size(36.dp).padding(6.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {


                Text(
                    "Paracetamol 500 mg",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = sora,
                )

                Text(
                    "2.0 Caplets After meal",
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF4D4D4D),
                    fontSize = 12.sp,
                    fontFamily = sora,
                )

            }
        }
    }
}