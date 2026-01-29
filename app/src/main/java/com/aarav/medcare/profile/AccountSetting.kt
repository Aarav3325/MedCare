package com.aarav.medcare.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.components.MedicineDropDown
import com.aarav.medcare.components.PasswordTextFields
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AccountSettings(
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    "Account Setting",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    fontFamily = sora,
                    textAlign = TextAlign.Center
                )
            }, navigationIcon = {
                IconButton(
                    onClick = {
                         back()
                    }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back arrow",
                        tint = Color(0xFF4D4D4D),
                        modifier = Modifier.size(24.dp)
                    )
                }
            })
        }) {

        var password by remember {
            mutableStateOf("")
        }

        var selectedLanguage by remember {
            mutableStateOf("English")
        }

        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            PasswordTextFields(
                text = password,
                onValueChange = {
                    password = it
                },
                label = "Password",
                placeholder = "Enter your password",
                false
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Language",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF26408B)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            MedicineDropDown(
                selectedValue = selectedLanguage,
                trailingText = "",
                placeholder = "",
                onValueSelected = {
                    selectedLanguage = it
                },
                listOfValues = listOf(
                    "Hindi", "Gujarati", "Tamil"
                )
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Privacy Settings",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF26408B)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                border = BorderStroke(1.dp, Color(0xFFA6CFD5))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(14.dp).fillMaxWidth()
                ) {
                    Text(
                        text = "Information privacy",
                        fontSize = 14.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "arrow right",
                        tint = Color(0xFF4D4D4D),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}