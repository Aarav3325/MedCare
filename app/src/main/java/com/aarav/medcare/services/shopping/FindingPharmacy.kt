package com.aarav.medcare.services.shopping

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@Composable
fun FindingPharmacy() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.pharmacy),
                contentDescription = "pharmacy image",
                modifier = Modifier.size(160.dp)
            )


            Spacer(Modifier.height(16.dp))

            Text(
                "Finding Nearest Pharmacy...",
                fontFamily = sora,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(12.dp))

            InstructionRow("Pricing, product availability, and shipping methods may differ.")
            InstructionRow("Select the delivery method that fits your requirements. Same-Day Delivery and Next-Day Delivery")
        }
    }
}

@Composable
fun InstructionRow(
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.filled_plus),
            contentDescription = "filled plus",
            modifier = Modifier.size(24.dp)
        )

        Text(
            text,
            fontFamily = sora,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF4D4D4D)
        )
    }
}