package com.aarav.medcare.services.chatdoctor

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import com.aarav.medcare.R
import com.aarav.medcare.components.WorkingHoursGrid
import com.aarav.medcare.services.Review
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DoctorDetailScreen(
    back: () -> Unit,
    navigateToConfirmation: () -> Unit,
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0XFFF6F1FF)
                ),
                title = {
                    Text(
                        "Doctor Details",
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
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.share),
                            contentDescription = "share action",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            val timings = ServiceData.timings
            val scheduleList = ServiceData.schedule
            val reviewList = ServiceData.reviewList

            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 108.dp)
            ) {
                DoctorInfoCard()

                Section {
                    DoctorAdditionalInfo()
                }

                Section("Practice Location") {
                    PracticeSection()
                }

                Section("Working Hours") {
                    WorkingHoursGrid(timings)
                }

                Section("Schedule") {
                    ScheduleRow(scheduleList)
                }

                Section("Review") {
                    ReviewRow(reviewList)
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                FilledTonalButton(
                    modifier = Modifier.height(48.dp).weight(1f),
                    onClick = {},
                    shape = RoundedCornerShape(24.dp),
                    border = BorderStroke(1.dp, Color(0xFF26408B)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF26408B)
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.chat),
                        contentDescription = "chat icon",
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(Modifier.width(8.dp))

                    Text(
                        text = "Chat",
                        fontFamily = sora,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Spacer(Modifier.width(12.dp))

                FilledTonalButton(
                    modifier = Modifier.height(48.dp).weight(2f),
                    onClick = {
                        navigateToConfirmation()
                    },
                    shape = RoundedCornerShape(24.dp),
                    border = BorderStroke(1.dp, Color(0xFF26408B)),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        text = "Make An Appointment",
                        fontFamily = sora,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorInfoCard() {
    Box(
        modifier = Modifier.fillMaxWidth().height(250.dp).
        background(
            Color(0XFFF6F1FF)
        )
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
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

            Spacer(Modifier.height(14.dp))

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
}

@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    rating: Float,
    onRatingChanged: (Float) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val icon = if (isSelected) Icons.Filled.Star else Icons.Outlined.Star
            val iconTintColor = if (isSelected) Color(0xFFFFC107) else Color.LightGray

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .size(24.dp)
                    .selectable(
                        selected = isSelected,
                        onClick = {
                            onRatingChanged(i.toFloat())
                        }
                    )
            )
        }
    }
}

@Composable
fun Section(
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(start = 16.dp, end = 16.dp , top = 24.dp),

    ) {
        title?.let {
            Text(
                it,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                fontFamily = sora
            )


            Spacer(modifier = Modifier.height(14.dp))
        }


        content()
    }
}

@Composable
fun PracticeSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(androidx.compose.foundation.BorderStroke(0.dp, color = Color.Transparent), shape = RoundedCornerShape(6.dp))
            .background(Color(0xFFF6F1FF))
            .padding(horizontal = 16.dp)
            .height(52.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Rossi Cardiology Clinic",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color(0xFF26408B),
            fontFamily = sora
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(24.dp),
            contentDescription = "down icon",
            tint = Color(0xFF4D4D4D)
        )
    }
}

@Composable
fun ScheduleRow(
    scheduleList: List<Pair<String, String>>
) {
    LazyRow() {
        items(scheduleList) {
            schedule ->
            DateCard(schedule)
        }
    }
}

@Composable
fun DoctorAdditionalInfo() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoItem("Education", "University of Milan", Modifier.weight(1f))

        InfoItem("License", "1276126552881", Modifier.weight(1f))
    }
}

@Composable
fun InfoItem(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .height(61.dp)
            //.size(width = 170.dp, height = 61.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 12.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                title,
                fontFamily = sora,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(8.dp))

            Text(
                content,
                fontFamily = sora,
                color = Color(0xFF26408B),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun TimeCard(
    time: String
) {
    Card(
        border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color(0xFF4D4D4D)
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                time,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DateCard(
    schedule: Pair<String, String>
){
    Card(
        border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color(0xFF4D4D4D)
        ),
        modifier = Modifier.padding(4.dp)
            .size(60.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                schedule.first,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )

            Spacer(Modifier.height(6.dp))

            Text(
                schedule.second,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}


@Composable
fun ReviewRow(reviewList: List<Review>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier
    ) {
        items(reviewList) {
            review -> ReviewBox(review)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewBox(
    review: Review
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier.padding(horizontal = 8.dp).width(275.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .animateContentSize()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(review.image),
                        contentDescription = "review profile",
                        modifier = Modifier.size(56.dp),
                    )
                }

                Spacer(Modifier.width(16.dp))

                Column() {
                    Text(
                        review.name,
                        fontFamily = sora,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                    )


                    Text(
                        review.relativeTime,
                        fontWeight = FontWeight.W400,
                        fontFamily = sora,
                        color = Color(0xFF4D4D4D),
                        fontSize = 10.sp
                    )


                    StarRatingBar(rating = review.rating) {
                    }
                }
            }


            Spacer(Modifier.height(8.dp))

            Text(
                text = review.review,
                maxLines = if (expanded) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
                fontFamily = sora,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = if (expanded) "Less" else "More view",
                color = Color(0xFF3F51B5),
                fontWeight = FontWeight.SemiBold,
                fontFamily = sora,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        expanded = !expanded
                    }
            )
        }
    }
}