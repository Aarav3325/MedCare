package com.aarav.medcare.services.reminder

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.auth.DatePickerFieldToModal
import com.aarav.medcare.components.MedicineDropDown
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.services.chatdoctor.NotificationSwitch
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddMedicine(
    back: () -> Unit,
    navigateToAllReminders: () -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Details about the drug",
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
        var selectedDosage by remember {
            mutableStateOf("")
        }
        var periodOfMedicine by remember {
            mutableStateOf("")
        }
        var timesPerDay by remember {
            mutableStateOf("")
        }
        var medicineTimings by remember {
            mutableStateOf("")
        }
        var drinkingRules by remember {
            mutableStateOf("")
        }
        var durationOfConsumption by remember {
            mutableStateOf("")
        }
        var notes by remember {
            mutableStateOf("")
        }
        var isChecked by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            MedicineInfoCard()

            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.padding(16.dp),
                border = BorderStroke(1.dp, Color(0xFFE3E3E3))
            ) {

                Column() {

                    ImageBox()

                    FormItem(
                        "Dosage",
                        selectedDosage,
                        "Caplets",
                        "Choose",
                        {
                            selectedDosage = it
                        },
                        listOfValues = listOf("1.0", "2.0", "3.0")
                    )

                    FormItem(
                        "Period of Taking Medicine",
                        periodOfMedicine,
                        "",
                        "Choose",
                        {
                            periodOfMedicine = it
                        },
                        listOfValues = listOf("Every Day", "Alternate Days", "Every 3 days")
                    )

                    FormItem(
                        "How Many Times a Day",
                        timesPerDay,
                        "Times",
                        "Choose",
                        {
                            timesPerDay = it
                        },
                        listOfValues = listOf("1", "2", "3", "4", "5")
                    )

                    FormItem(
                        "Time to Take Medicine",
                        medicineTimings,
                        "",
                        "Choose",
                        {
                            medicineTimings = it
                        },
                        listOfValues = ServiceData.timings
                    )

                    FormItem(
                        "Drinking Rules",
                        drinkingRules,
                        "",
                        "Choose",
                        {
                            drinkingRules = it
                        },
                        listOfValues =
                            listOf(
                                "Before Breakfast, After Breakfast",
                                "Before Lunch", "After Lunch",
                                "Before Dinner", "After Dinner",
                            )
                    )

                    Column(
                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)
                    ) {
                        DatePickerFieldToModal(
                            "Drinking Start Date",
                            Color.Black,
                            "Choose",
                        )
                    }

                    FormItem(
                        "Duration of Consumption",
                        durationOfConsumption,
                        "",
                        "Choose",
                        {
                            durationOfConsumption = it
                        },
                        listOfValues =
                            listOf(
                                "1 Weeks", "2 Weeks", "3 Weeks", "4 Weeks"
                            )
                    )

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "Notes (Optional)",
                            fontSize = 14.sp,
                            fontFamily = sora,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = notes,
                            onValueChange = {
                                notes = it
                            },
                            readOnly = false,
                            placeholder = {
                                Text(text = "Add your notes")
                            },
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFFA6CFD5),
                                unfocusedBorderColor = Color(0xFFA6CFD5),
                            )
                        )
                    }
                }
            }

            NotificationSwitch(
                isChecked = isChecked,
                onCheckedChange = {
                    isChecked = !isChecked
                },
                Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            FilledTonalButton(
                onClick = {
                    navigateToAllReminders()
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 24.dp
                    )
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Save",
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
fun MedicineInfoCard() {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults
            .cardColors(
                containerColor = Color(0xFFC2E7D9)
            ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "Paracetamol 500 mg",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = sora,
            )


            Text(
                "Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                fontWeight = FontWeight.Normal,
                color = Color(0xFF4D4D4D),
                fontSize = 12.sp,
                fontFamily = sora,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicineForm() {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))
    ) {
        Column() {
            ImageBox()
        }
    }
}

@Composable
fun FormItem(
    title: String,
    selectedValue: String,
    trailingText: String,
    placeholder: String,
    onValueSelected: (String) -> Unit,
    listOfValues: List<String>
) {
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontFamily = sora,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        MedicineDropDown(
            selectedValue,
            trailingText,
            placeholder,
            onValueSelected,
            listOfValues
        )
    }
}

@Composable
fun ImageBox() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = "Medicine Details",
            fontSize = 14.sp,
            fontFamily = sora,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Surface(
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(R.drawable.camera),
                contentDescription = "camera icon",
                modifier = Modifier.size(80.dp)
            )
        }

    }
}