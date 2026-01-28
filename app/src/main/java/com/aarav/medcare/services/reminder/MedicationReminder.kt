package com.aarav.medcare.services.reminder

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MedicationReminder(
    back: () -> Unit,
    navigateToAll: () -> Unit,
    navigateToAddMedicine: () -> Unit,
) {
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
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            Column(
            ) {
                SectionRowMedication(
                    "Reminder to Take Medicine",
                    "See all",
                    Icons.Default.KeyboardArrowRight,
                    navigateToAll
                )

                EmptyStateCard(
                    image = R.drawable.medicine_empty_1,
                    "Manage your medication",
                    "Add the medicine you are taking and create a reminder to take the medicine"
                )


                SectionRowMedication(
                    "History of Taking Medication"
                ){}

                EmptyStateCard(
                    image = R.drawable.medicine_empty_1,
                    "View all your medication history",
                    "Add the medicine you are taking and create a reminder to take the medicine"
                )

            }

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
//Manage your medication Add the medicine you are taking and create a reminder to take the medicine
@Preview(showBackground = true)
@Composable
fun EmptyStateCard(
    image: Int,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp ,Color(0xFFC2E7D9))
    ) {
        Column(
            modifier = Modifier.padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "empty",
                modifier = Modifier.size(128.dp)
            )

            Spacer(Modifier.height(16.dp))

            Text(
                title,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = sora,
            )

            Spacer(Modifier.height(8.dp))

            Text(
                description,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF4D4D4D),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontFamily = sora,
            )
        }
    }
}

@Composable
fun SectionRowMedication(
    title: String,
    buttonText: String? = null,
    buttonIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            title,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4D4D4D),
            fontSize = 16.sp,
            fontFamily = sora,
        )

        buttonText?.let {
            buttonText ->
            TextButton(
                contentPadding = PaddingValues(0.dp),
                onClick = onClick
            ) {
                Text(
                    buttonText,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF26408B),
                    fontSize = 14.sp,
                    fontFamily = sora,
                )

                buttonIcon?.let {
                    Icon(
                        imageVector = it,
                        tint = Color(0xFF26408B),
                        contentDescription = "arrow"
                    )
                }
            }
        }
    }
}