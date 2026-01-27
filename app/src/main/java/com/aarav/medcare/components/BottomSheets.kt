package com.aarav.medcare.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.Product
import com.aarav.medcare.services.chatdoctor.NotificationSwitch
import com.aarav.medcare.services.chatdoctor.ScheduleRow
import com.aarav.medcare.services.chatdoctor.Section
import com.aarav.medcare.services.chatdoctor.StarRatingBar
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomButtonSheets(
    sheetState: SheetState,
    onDismiss: () -> Unit,
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color.White,
        dragHandle = {
            Spacer(modifier = Modifier.height(12.dp))

            HorizontalDivider(
                modifier = Modifier.width(80.dp),
                thickness = 4.dp,
                color = Color(0xFFA6CFD5)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            title?.let {
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    it,
                    fontFamily = sora,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RescheduleModalContent(
    timings: List<String>,
    scheduleList: List<Pair<String, String>>,
    onCancelClick: () -> Unit
) {
    Column(
    ) {
        Section("Working Hours") {
            WorkingHoursGrid(timings)
        }

        Section("Schedule") {
            ScheduleRow(scheduleList)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            FilledTonalButton(
                onClick = {
                    onCancelClick()
                },
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                border = BorderStroke(1.dp, Color(0xFFA6CFD5)),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Cancel",
                    fontSize = 12.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold
                )
            }


            FilledTonalButton(
                onClick = {},
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    // containerColor = Color.Transparent,
                    containerColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Reschedule",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun ReviewSheetContent(
    onCancelClick: () -> Unit
) {
    var reviewText by remember {
        mutableStateOf("")
    }

    var rating by remember {
        mutableFloatStateOf(0F)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Ratings",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = sora
        )


        Spacer(Modifier.height(8.dp))

        StarRatingBar(rating = rating) {
            rating = it
        }

        Spacer(Modifier.height(24.dp))

        Text(
            "Your Review",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = sora
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = reviewText,
            onValueChange = {
                reviewText = it
            },
            maxLines = 6,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            shape = RoundedCornerShape(6.dp),
            placeholder = {
                Text("Write a review", fontFamily = sora, color = Color.Gray)
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color(0xFFE3E3E3),
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color(0xFF26408B)
            )
        )


        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {

            FilledTonalButton(
                onClick = {
                    onCancelClick()
                },
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                border = BorderStroke(1.dp, Color(0xFFA6CFD5)),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Cancel",
                    fontSize = 12.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold
                )
            }


            FilledTonalButton(
                onClick = {},
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    // containerColor = Color.Transparent,
                    containerColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Save Review",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun NotificationSheetContent(
    onSubmitClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        var isChecked by remember {
            mutableStateOf(false)
        }

        NotificationSwitch(
            isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )

        Spacer(Modifier.height(16.dp))

        FilledTonalButton(
            onClick = {
                onSubmitClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                // containerColor = Color.Transparent,
                containerColor = Color(0xFF26408B)
            )
        ) {
            Text(
                "Submit",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CartBottomSheet(
    product: Product,
    count: Int,
    onDismiss: () -> Unit,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit
) {
    Column() {
        Card(
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(product.productImage),
                    contentDescription = "product image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(140.dp)
                        .weight(1f)
                )


                Column(
                    modifier = Modifier.weight(1.5f),
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Text(
                        product.productName,
                        fontFamily = sora,
                        style = TextStyle(
                            lineHeight = 15.sp
                        ),
                        maxLines = 2,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(
                        "Per strip",
                        fontFamily = sora,
                        maxLines = 1,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF8F8F8F)
                    )

                    Spacer(Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            "Start from",
                            fontFamily = sora,
                            maxLines = 1,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.W400,
                            color = Color(0xFF8F8F8F)
                        )
                        Text(
                            "$${product.price}",
                            fontFamily = sora,
                            maxLines = 2,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF26408B)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .border(
                                    1.dp,
                                    Color(0xFF26408B),
                                    RoundedCornerShape(6.dp)
                                )
                                .clickable {
                                    onDecrease()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.minus),
                                contentDescription = "remove item",
                                modifier = Modifier.size(14.dp)
                            )
                        }


                        Text(
                            count.toString(),
                            fontFamily = sora,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400
                        )

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .border(
                                    1.dp,
                                    Color(0xFF26408B),
                                    RoundedCornerShape(6.dp)
                                )
                                .clickable {
                                    onIncrease()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.plus),
                                contentDescription = "remove item",
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }

        FilledTonalButton(
            onClick = {
                onDismiss()
            },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF26408B)
            )
        ) {
            Text(
                "Add to Cart",
                fontSize = 16.sp,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}