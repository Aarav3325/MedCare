package com.aarav.medcare.auth

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.components.AuthScreenTextFields
import com.aarav.medcare.components.GenderDropDown
import com.aarav.medcare.components.PhoneNumberTextField
import com.aarav.medcare.ui.theme.sora
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class Tabs {
    PHONE, EMAIL
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit,
    navigateToLogin: () -> Unit,
    back: () -> Unit,
) {

    var selectedDestination by rememberSaveable { mutableIntStateOf(0) }


    var phoneVisible by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            back()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "back"
                        )
                    }
                },
                modifier = Modifier.padding(10.dp)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {

            Text(
                text = "Complete Personal Identification",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "You can connect with all healthcare facilities you've previously visited.",
                fontSize = 14.sp,
                color = Color(0xFF4D4D4D),
                fontWeight = FontWeight.W400
            )


            Spacer(modifier = Modifier.height(22.dp))

            SecondaryTabRow(
                contentColor = Color(0xFF26408B),
                indicator = {
                    TabRowDefaults.SecondaryIndicator(
                        color = Color(0xFF26408B),
                        modifier =
                            Modifier.tabIndicatorOffset(
                                selectedDestination,
                                matchContentSize = false
                            )
                    )
                },
                selectedTabIndex = selectedDestination
            ) {
                Tabs.entries.forEachIndexed { index, destination ->
                    Log.i("MYTAG", "selected $selectedDestination index $index")

                    Tab(
                        selected = selectedDestination == index,
                        onClick = {
                            //navController.navigate(route = destination)
                            selectedDestination = index
                        },
                        selectedContentColor = Color(0xFF26408B),
                        unselectedContentColor = Color(0xFFA6CFD5),
                        text = {
                            Text(
                                text = destination.name.uppercase(),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )

                        }
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            RegisterContent(phoneVisible, navigateToLogin, onRegisterClick)

            LaunchedEffect(selectedDestination) {
                if(selectedDestination == 0) {
                    phoneVisible = true
                }
                else{
                    phoneVisible = false
                }
            }

        }


    }
}

enum class Gender {
    MALE, FEMALE, OTHER
}

@Composable
fun RegisterContent(phoneVisible: Boolean,
                    navigateToLogin: () -> Unit,
                    onRegisterClick: () -> Unit) {

    var email by remember {
        mutableStateOf("")
    }


    var fullName by remember {
        mutableStateOf("")
    }

    var gender by remember {
        mutableStateOf("")
    }

    var isChecked by remember {
        mutableStateOf(false)
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }



    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {


            if(!phoneVisible) {
                AuthScreenTextFields(
                    text = email,
                    onValueChange = {
                        email = it
                    },
                    label = "Email",
                    placeholder = "Enter your email"
                )
            }
            else{
                PhoneNumberTextField(
                    phoneNumber
                ) {
                    phoneNumber = it
                }
            }



            Spacer(Modifier.height(26.dp))

            AuthScreenTextFields(
                text = fullName,
                onValueChange = {
                    fullName = it
                },
                label = "Full name",
                placeholder = "Enter your full name"
            )


            Spacer(Modifier.height(26.dp))

            Text(
                text = "Gender",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF26408B)
            )

            Spacer(modifier = Modifier.height(8.dp))

            GenderDropDown(
                selectedGender = gender,
                onGenderSelected = {
                    gender = it
                }
            )

            Spacer(Modifier.height(26.dp))

            DatePickerFieldToModal(
                "Date of birth",
                Color(0xFF26408B),
                "Select your date of birth",
            )


            Spacer(Modifier.height(26.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                CompositionLocalProvider(
                    LocalMinimumInteractiveComponentSize provides Dp.Unspecified
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            uncheckedColor = Color(0xFFA6CFD5),
                            checkedColor = Color(0xFF26408B)
                        )
                    )
                }


                Text(
                    "You agree to receive information and notifications \nsent by MedCare",
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FilledTonalButton(
                onClick = {
                    onRegisterClick()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF26408B),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    "Register",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Already have an account?",
                    color = Color.Gray,
                    fontSize = 14.sp,
                )

                Spacer(Modifier.width(4.dp))

                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        navigateToLogin()
                    }
                ) {
                    Text(
                        text = "Click here to log in",
                        color = Color(0xFF26408B),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

        }
    }
}

@Composable
fun DatePickerFieldToModal(
    title: String,
    titleColor: Color,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var showModal by remember { mutableStateOf(false) }

    Text(
        text = title,
        fontSize = 14.sp,
        fontFamily = sora,
        fontWeight = FontWeight.SemiBold,
        color = titleColor
    )

    Spacer(Modifier.height(8.dp))

    OutlinedTextField(
        value = selectedDate?.let { convertMillisToDate(it) } ?: "",
        onValueChange = { },
        placeholder = { Text(placeholder) },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select date")
        },
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFA6CFD5), RoundedCornerShape(6.dp))
            .pointerInput(selectedDate) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
    )

    if (showModal) {
        DatePickerModal(
            onDateSelected = { selectedDate = it },
            onDismiss = { showModal = false }
        )
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}