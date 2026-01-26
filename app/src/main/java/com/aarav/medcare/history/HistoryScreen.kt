package com.aarav.medcare.history

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.components.CustomButtonSheets
import com.aarav.medcare.components.NotificationSheetContent
import com.aarav.medcare.components.RescheduleModalContent
import com.aarav.medcare.components.ReviewSheetContent
import com.aarav.medcare.services.Appointment
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

enum class HistoryTabs {
    UPCOMING,
    COMPLETED
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HistoryScreen(
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "History",
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
//        Column(
//            modifier = Modifier
//                .padding(it)
//                .fillMaxSize()
//                .padding(bottom = 80.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth()
//                    .background(Color(0xFFF9F8FD))
//                    .border(1.dp, Color(0xFFE3E3E3), RoundedCornerShape(6.dp))
//            ) {
//
//                SingleChoiceSegmentedButtonRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 2.dp, horizontal = 4.dp)
//                ) {
//                    HistoryTabs.entries.forEachIndexed { index, tabs ->
//                        val isSelected = selectedIndex == index
//                        SegmentedButton(
//                            colors = SegmentedButtonDefaults.colors(
//                                activeContainerColor = Color(0xFF26408B),
//                                activeContentColor = Color.White,
//                                inactiveContentColor = Color(0xFF8F8F8F)
//                            ),
//                            border = BorderStroke(0.dp, Color.Transparent),
//                            selected = index == selectedIndex,
//                            onClick = {
//                                selectedIndex = index
//                            },
//                            icon = {},
//                            label = {
//                                Text(
//                                    tabs.name,
//                                    fontSize = 16.sp,
//                                    fontFamily = sora,
//                                    fontWeight = FontWeight.SemiBold
//                                )
//                            },
//                            modifier = Modifier
//                                .weight(1f)
//                                .padding(),
//                            shape = if (isSelected) RoundedCornerShape(6.dp) else RoundedCornerShape(
//                                0.dp
//                            )
//                        )
//                    }
//                }
//            }
//
//            LateralTabContent(
//                selectedIndex = selectedIndex,
//                modifier = Modifier
//            ) { index ->
//
//                LazyColumn {
//                    if (index == 0) {
//                        items(upcoming) { appointment ->
//                            AppointmentCard(appointment)
//                        }
//                    } else {
//                        items(completed) { appointment ->
//                            AppointmentCard(appointment)
//                        }
//                    }
//                }
//            }
//        }


        var selectedIndex by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(bottom = 80.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFF9F8FD))
                    .border(1.dp, Color(0xFFE3E3E3), RoundedCornerShape(6.dp))
            ) {

                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp, horizontal = 4.dp)
                ) {
                    HistoryTabs.entries.forEachIndexed { index, tabs ->
                        val isSelected = selectedIndex == index
                        SegmentedButton(
                            colors = SegmentedButtonDefaults.colors(
                                activeContainerColor = Color(0xFF26408B),
                                activeContentColor = Color.White,
                                inactiveContentColor = Color(0xFF8F8F8F)
                            ),
                            border = BorderStroke(0.dp, Color.Transparent),
                            selected = index == selectedIndex,
                            onClick = {
                                selectedIndex = index
                            },
                            icon = {},
                            label = {
                                Text(
                                    tabs.name,
                                    fontSize = 16.sp,
                                    fontFamily = sora,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(),
                            shape = if (isSelected) RoundedCornerShape(6.dp) else RoundedCornerShape(
                                0.dp
                            )
                        )
                    }
                }
            }

            Log.i("MYTAG", "selected: $selectedIndex")
            val appointmentList = ServiceData.appointmentList

            val upcoming = appointmentList.filter { !it.isCompleted }
            val completed = appointmentList.filter { it.isCompleted }

            if (!upcoming.isEmpty() && selectedIndex == 0) {
                UpcomingEmpty()
            }

            if (!completed.isEmpty() && selectedIndex == 1) {
                CompletedEmpty()
            }

//            if (!upcoming.isEmpty() || !completed.isEmpty()) {
//                LazyColumn() {
//                    if (selectedIndex == 0) {
//                        items(upcoming) { appointment ->
//                            AppointmentCard(appointment)
//                        }
//                    } else {
//                        items(completed) { appointment ->
//                            AppointmentCard(appointment)
//                        }
//                    }
//                }
//            }
        }
    }
}

@Composable
fun LateralTabContent(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    content: @Composable (Int) -> Unit
) {
    var previousIndex by remember { mutableIntStateOf(selectedIndex) }

    val direction = if (selectedIndex > previousIndex) 1 else -1

    AnimatedContent(
        targetState = selectedIndex,
        transitionSpec = {
            slideInHorizontally(
                animationSpec = tween(350, easing = FastOutSlowInEasing)
            ) { it * direction } +
                    fadeIn(animationSpec = tween(120)) togetherWith
                    slideOutHorizontally(
                        animationSpec = tween(350, easing = FastOutSlowInEasing)
                    ) { -it * direction } +
                    fadeOut(animationSpec = tween(120))
        },
        modifier = modifier,
        label = "LateralTabs"
    ) { index ->
        content(index)
    }

    LaunchedEffect(selectedIndex) {
        previousIndex = selectedIndex
    }
}


enum class ActiveSheet {
    RESCHEDULE, REVIEW, NOTIFICATION
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppointmentCard(
    appointment: Appointment
) {


    val timings = ServiceData.timings
    val schedule = ServiceData.schedule
    val modalSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    var activeSheet by remember {
        mutableStateOf<ActiveSheet?>(null)
    }

    val title = when (activeSheet) {
        ActiveSheet.RESCHEDULE -> "Reschedule Appointment"
        ActiveSheet.NOTIFICATION -> "Notification"
        ActiveSheet.REVIEW -> "Review"
        else -> ""
    }

    if (showBottomSheet) {
        CustomButtonSheets(
            sheetState = modalSheetState,
            title = title,
            onDismiss = { showBottomSheet = false }
        ) {
            when (activeSheet) {
                ActiveSheet.RESCHEDULE -> RescheduleModalContent(
                    timings,
                    schedule
                ) { showBottomSheet = false }

                ActiveSheet.REVIEW -> ReviewSheetContent { showBottomSheet = false }
                ActiveSheet.NOTIFICATION -> NotificationSheetContent { showBottomSheet = false }
                else -> null
            }
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        appointment.doctorName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sora
                    )

                    Text(
                        appointment.speciality,
                        fontSize = 12.sp,
                        color = Color(0xFF4D4D4D),
                        fontWeight = FontWeight.W400,
                        fontFamily = sora
                    )
                }

                Image(
                    painter = painterResource(appointment.doctorImage),
                    contentDescription = "doctor profile",
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(Modifier.height(24.dp))

            HorizontalDivider()

            Spacer(Modifier.height(24.dp))

            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Date & Time",
                        fontSize = 14.sp,
                        fontFamily = sora,
                        color = Color(0xFF4D4D4D)
                    )

                    Spacer(Modifier.height(6.dp))
                    Text(
                        appointment.dateAndTime,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sora,
                        color = Color(0xFF26408B)
                    )
                }


                Spacer(Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Location",
                        fontSize = 14.sp,
                        fontFamily = sora,
                        color = Color(0xFF4D4D4D)
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        appointment.location,
                        fontSize = 14.sp,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sora,
                        color = Color(0xFF26408B)
                    )
                }

                Spacer(Modifier.height(6.dp))
            }
        }

        if (appointment.isCompleted) {
            ActionsRowCompleted(
                onAddReviewClick = {
                    showBottomSheet = true
                    activeSheet = ActiveSheet.REVIEW
                }
            )
        } else {
            ActionsRowUpcoming(
                onRescheduleClick = {
                    showBottomSheet = true
                    activeSheet = ActiveSheet.RESCHEDULE
                },
                onNotificationClick = {
                    showBottomSheet = true
                    activeSheet = ActiveSheet.NOTIFICATION
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActionsRowUpcoming(
    onNotificationClick: () -> Unit,
    onRescheduleClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF6F1FF).copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.notification),
                        contentDescription = "bell",
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(Modifier.width(6.dp))

                    Text(
                        "Notifications",
                        fontSize = 12.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF4D4D4D),
                        modifier = Modifier
                    )

                    Spacer(Modifier.width(6.dp))

                    Text(
                        "Off",
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline,
                            color = Color(0xFF26408B)
                        ),
                        fontSize = 12.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF26408B),
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = null
                            ) {
                                onNotificationClick()
                            }
                    )
                }

                FilledTonalButton(
                    onClick = {
                        onRescheduleClick()
                    },
                    modifier = Modifier.weight(1.2f),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        "Reschedule",
                        fontSize = 12.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ActionsRowCompleted(
    onAddReviewClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF6F1FF).copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            FilledTonalButton(
                onClick = {
                    onAddReviewClick()
                },
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp, Color(0xFFA6CFD5)),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Add Review",
                    fontSize = 12.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold
                )
            }


            FilledTonalButton(
                onClick = {},
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp, Color(0xFFA6CFD5)),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF26408B)
                )
            ) {
                Text(
                    "Next Appointment",
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
fun LateralTabTransition(
    targetPage: HistoryTabs,
    modifier: Modifier = Modifier,
    content: @Composable (HistoryTabs) -> Unit
) {
    var previousPage by remember { mutableStateOf(targetPage) }

    val direction = if (targetPage.ordinal > previousPage.ordinal) {
        1 // forward → right
    } else {
        -1 // backward → left
    }

    AnimatedContent(
        targetState = targetPage,
        transitionSpec = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) { width -> width * direction } +
                    fadeIn(animationSpec = tween(150)) togetherWith
                    slideOutHorizontally(
                        animationSpec = tween(300)
                    ) { width -> -width * direction } +
                    fadeOut(animationSpec = tween(150))
        },
        modifier = modifier
    ) { page ->
        content(page)
    }

    LaunchedEffect(targetPage) {
        previousPage = targetPage
    }
}

@Preview(showBackground = true)
@Composable
fun UpcomingEmpty() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.upcoming_empty),
                contentDescription = "no upcoming appointments",
                modifier = Modifier.size(160.dp)
            )

            Spacer(Modifier.height(24.dp))

            Text(
                "Next visit schedule",
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "You don't have a future visit scheduled. make an appointment with the doctor now",
                fontFamily = sora,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                color = Color(0xFF4D4D4D),
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompletedEmpty() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.completed_empty),
                contentDescription = "no recent appointments",
                modifier = Modifier.size(160.dp)
            )

            Spacer(Modifier.height(24.dp))

            Text(
                "You don't have any schedule yet",
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "You've never had a doctor's appointment, do it now",
                fontFamily = sora,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                color = Color(0xFF4D4D4D),
                fontSize = 14.sp
            )
        }
    }
}