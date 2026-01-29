package com.aarav.medcare.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthScreenTextFields(
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
) {
    Column {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF26408B)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = text,
            onValueChange = {
                onValueChange(it)
            },

            placeholder = {
                Text(
                    text = placeholder,
                    color = Color.Gray
                )
            },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFFA6CFD5), RoundedCornerShape(6.dp))
        )
    }
}

@Composable
fun PasswordTextFields(
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isPasswordVisible: Boolean
) {
    Column {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF26408B)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = text,
            onValueChange = {
                onValueChange(it)
            },

            placeholder = {
                Text(
                    text = placeholder,
                    color = Color.Gray
                )
            },
            visualTransformation = if (!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFFA6CFD5), RoundedCornerShape(6.dp))
        )
    }
}

@Composable
fun PhoneNumberTextField(
    phone: String,
    onPhoneChange: (String) -> Unit
) {

    Column {
        Text(
            text = "Phone No.",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF26408B)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = {
                if (it.length <= 10 && it.all { ch -> ch.isDigit() }) {
                    onPhoneChange(it)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter phone number", color = Color.Gray) },
            leadingIcon = {
                Text(
                    text = "+91",
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 8.dp)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
            ),
            singleLine = true,
            shape = RoundedCornerShape(6.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF26408B),
                unfocusedBorderColor = Color(0xFFA6CFD5),
                cursorColor = Color(0xFF26408B)
            )
        )
    }
}
