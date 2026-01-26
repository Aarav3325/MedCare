package com.aarav.medcare.services.chatdoctor

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
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
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@Composable
fun AppointmentSuccessScreen(
    back: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.appointment_success),
                contentDescription = "success illustration",
                modifier = Modifier.size(width = 170.dp, height = 150.dp)
            )

            Spacer(Modifier.height(36.dp))

            Text(
                "Appointments have been made",
                fontFamily = sora,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )


            Spacer(Modifier.height(36.dp))

            Text(
                "Prepare your attendance well, arrive 30 minutes before the appointed time",
                fontFamily = sora,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color(0xFF4D4D4D),
                fontWeight = FontWeight.W400
            )

            Spacer(Modifier.height(24.dp))

            FilledTonalButton(
                onClick = {
                    back()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF26408B)
                ),
                modifier = Modifier.width(200.dp).height(40.dp),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color(0xFFA6CFD5))
            ) {
                Text(
                    "Go To Details",
                    fontFamily = sora,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}