package com.aarav.medcare.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TransactionScreen(
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    "Transaction",
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

        val transactionList = ProfileData.transactionList

        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(transactionList) { transaction ->
                TransactionItem(transaction)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TransactionItem(
    transaction: Transaction
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(12.dp)
                    .background(Color(0xFF8F8F8F))
                    .padding(12.dp)
            ) {
                Text(
                    transaction.date,
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora
                )
                Text(
                    transaction.month,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontFamily = sora
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row() {
                    Text(
                        transaction.paidTo,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sora,
                        modifier = Modifier.weight(0.1f)
                    )

                    if (transaction.isPaid) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFC2E7D9),
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Text(
                                "Paid",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.W400,
                                fontFamily = sora,
                                color = Color(0xFF26408B),
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp)
                            )
                        }
                    }
                }
                Text(
                    "$${transaction.amount}",
                    fontSize = 14.sp,
                    color = Color(0xFF26408B),
                    fontWeight = FontWeight.W400,
                    fontFamily = sora
                )
            }
        }
    }
}