package com.aarav.medcare.services.chatdoctor

import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ConfirmationScreen(
    back: () -> Unit,
    navigateToSuccess: () -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Confirmation",
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
        var isChecked by remember {
            mutableStateOf(true)
        }

        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column() {
                DoctorInfoCardConfirmation()


                AppointmentDetailCard()

                NotificationSwitch(
                    isChecked,
                    onCheckedChange = {
                        isChecked = it
                    },
                    Modifier.padding(16.dp)
                )

            }

            ConfirmButton(navigateToSuccess, Modifier.align(Alignment.BottomCenter))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DoctorInfoCardConfirmation() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))
    ) {
        Box(
            modifier = Modifier.wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        border = BorderStroke(4.dp, Color(0xFFA6CFD5))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.doctor1),
                            contentDescription = "doctor profile",
                            modifier = Modifier.size(100.dp),
                        )
                    }

                    Spacer(Modifier.width(16.dp))

                    Column() {
                        Text(
                            "Dr. Luca Rossi",
                            fontFamily = sora,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                        )

                        Spacer(Modifier.height(8.dp))

                        Row {
                            Text(
                                "Cardiology Specialist ",
                                fontWeight = FontWeight.W400,
                                fontFamily = sora,
                                color = Color(0xFF4D4D4D),
                                fontSize = 12.sp
                            )

                            Text(
                                " · ",
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = sora,
                                color = Color(0xFF4D4D4D),
                                fontSize = 12.sp
                            )

                            Text(
                                " 3 Years",
                                fontWeight = FontWeight.W400,
                                fontFamily = sora,
                                color = Color(0xFF4D4D4D),
                                fontSize = 12.sp
                            )
                        }


                        Spacer(Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            StarRatingBar(rating = 4F) {

                            }

                            Text(
                                "12 Reviews",
                                fontWeight = FontWeight.W400,
                                fontFamily = sora,
                                color = Color(0xFF4D4D4D),
                                fontSize = 12.sp
                            )

                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                DoctorAdditionalInfo()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppointmentDetailCard() {
    Card(

        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Detail Appointment",
                fontFamily = sora,
                fontSize = 16.sp,
                color = Color(0xFF26408B),
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(24.dp))

            HorizontalDivider()


            Spacer(Modifier.height(24.dp))

            Text(
                "Date & Time",
                fontSize = 14.sp,
                fontFamily = sora,
                color = Color(0xFF4D4D4D)
            )

            Spacer(Modifier.height(6.dp))
            Text(
                "Wednesday, 22 Feb 1.00PM",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = sora,
                color = Color.Black
            )


            Spacer(Modifier.height(24.dp))

            Text(
                "Location",
                fontSize = 14.sp,
                fontFamily = sora,
                color = Color(0xFF4D4D4D)
            )

            Spacer(Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Rossi Cardiology Clinic\n" +
                            "Via Garibaldi 15, Milan, Italy",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora,
                    color = Color.Black,
                    modifier = Modifier.weight(0.1f)
                )

                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF26408B),
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(bottom = 12.dp, start = 12.dp, top = 8.dp)
                        .height(28.dp),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    Text(
                        "See maps",
                        fontFamily = sora
                    )

                    Spacer(Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "null",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationSwitch(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {


    Surface(
        border = BorderStroke(1.dp, Color(0xFFC2E7D9)),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.bell),
                contentDescription = "bell",
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.width(12.dp))

            Text(
                "Activate Notification",
                fontSize = 14.sp,
                fontFamily = sora,
                color = Color(0xFF4D4D4D),
                modifier = Modifier.weight(0.1f)
            )

            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color(0xFF26408B)
                )
            )
        }
    }
}

@Composable
fun ConfirmButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledTonalButton(
        shape = RoundedCornerShape(24.dp),
        //border = BorderStroke(1.dp, Color(0xFF26408B)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF26408B),
            contentColor = Color.White
        ),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Text(
            text = "Confirm Appointment",
            fontFamily = sora,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SwipeToConfirmButton(
) {
    val buttonWidth = 320.dp
    val buttonHeight = 56.dp
    val thumbSize = 48.dp

    val density = LocalDensity.current
    val maxOffsetPx = with(density) {
        (buttonWidth - thumbSize).toPx()
    }

    var offsetX by remember { mutableStateOf(0f) }
    val animatedOffset by animateFloatAsState(
        targetValue = offsetX,
        label = "thumbOffset"
    )

    Scaffold() {

        val width = 320.dp
        val height = 56.dp
        val thumbSize = 48.dp
        val cornerRadius = 28.dp

        val density = LocalDensity.current
        val maxOffsetPx = with(density) { ((width) - thumbSize - 12.dp).toPx() }

        var offsetX by remember { mutableStateOf(0f) }
        var confirmed by remember { mutableStateOf(false) }

        val animatedOffset by animateFloatAsState(
            targetValue = offsetX,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium
            ),
            label = "SwipeOffset"
        )

        Box(
            modifier = Modifier
                .padding(it)
                .width(width)
                .height(height)
                .clip(RoundedCornerShape(cornerRadius))
                .background(Color(0xFFF2F3F5)) // static background
                .border(
                    1.dp,
                    Color(0xFFE0E0E0),
                    RoundedCornerShape(cornerRadius)
                ),
            contentAlignment = Alignment.Center
        ) {

            // Center text
            Text(
                text = if (confirmed) "Booking Confirmed" else "Swipe to confirm",
                color = if (confirmed) Color(0xFF2E7D32) else Color.DarkGray,
                fontWeight = FontWeight.Medium
            )

            val context = LocalContext.current

            // Swipe Thumb
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .offset { IntOffset(animatedOffset.roundToInt(), 0) }
                    .size(thumbSize)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape)
                    .background(Color.White)
                    .draggable(
                        enabled = !confirmed,
                        orientation = Orientation.Horizontal,
                        state = rememberDraggableState { delta ->
                            offsetX = (offsetX + delta)
                                .coerceIn(0f, maxOffsetPx)
                        },
                        onDragStopped = {
                            if (offsetX > maxOffsetPx * 0.85f) {
                                offsetX = maxOffsetPx
                                confirmed = true
                                Toast
                                    .makeText(
                                        context,
                                        "Booking cofirmed",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            } else {
                                offsetX = 0f
                            }
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (confirmed)
                        Icons.Default.Check
                    else
                        Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}
