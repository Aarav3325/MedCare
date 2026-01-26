package com.aarav.medcare.auth

import android.util.Log
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.components.AuthScreenTextFields
import com.aarav.medcare.components.PhoneNumberTextField

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    navigateToRegister: () -> Unit,
    back: () -> Unit
) {


    var selectedDestination by rememberSaveable { mutableIntStateOf(0) }

    var phoneVisible by remember {
        mutableStateOf(true)
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
                text = "Enter your phone number or email",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
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

            LoginContent(phoneVisible, navigateToRegister, onLoginClick)

            LaunchedEffect(selectedDestination) {
                if (selectedDestination == 0) {
                    phoneVisible = true
                } else {
                    phoneVisible = false
                }
            }

        }
    }
}

@Composable
fun LoginContent(isPhoneVisible: Boolean,
                 navigateToRegister: () -> Unit,
                 onLoginClick: () -> Unit) {

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (isPhoneVisible) {
            Column() {
                PhoneNumberTextField(
                    phoneNumber
                ) {
                    phoneNumber = it
                }

                Spacer(Modifier.height(24.dp))

                Text(
                    "Is there an issue with your phone number?",
                    color = Color(0xFF26408B)
                )
            }
        } else {


            Column {
                AuthScreenTextFields(
                    email,
                    onValueChange = {
                        email = it
                    },
                    label = "Email",
                    placeholder = "Enter your email"
                )

                Spacer(Modifier.height(24.dp))

                Text(
                    "Is there an issue with your email?",
                    color = Color(0xFF26408B)
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
                    onLoginClick()
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
                    "Login",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Don't have a MedCare account yet?",
                    color = Color.Gray,
                    fontSize = 14.sp,
                )

                Spacer(Modifier.width(4.dp))

                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        navigateToRegister()
                    }
                ) {
                    Text(
                        text = "Sign up",
                        color = Color(0xFF26408B),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}