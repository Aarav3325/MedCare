package com.aarav.medcare.services.shopping

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Bullet
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.services.chatdoctor.ReviewRow
import com.aarav.medcare.services.chatdoctor.Section
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ProductDetailScreen(
    back: () -> Unit
) {
    val lazyListState = rememberLazyListState()

    val scroll = lazyListState.scrollIndicatorState?.scrollOffset ?: 0

    val isScrolled = scroll > lazyListState.firstVisibleItemScrollOffset

    val topBarText = if (isScrolled) "Bufect Strip of 4 Tablets -Heat and Pain Relief Medicine" else ""
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier.padding(bottom = 8.dp),
                title = {
                    AnimatedVisibility(isScrolled) {
                        Text(
                            topBarText,
                            fontSize = 14.sp,
                            style = TextStyle(
                                lineHeight = 20.sp
                            ),
                            fontFamily = sora,
                        )
                    }
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
                            contentDescription = "cart icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) {



//        if (isScrolled) {
//            AnimatedContent(
//                targetState = isScrolled
//            ) {
//                scroll ->
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ){
//
//                    Text("Scrolled")
//                }
//            }
//        } else {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.product_detail_image),
                                contentScale = ContentScale.Fit,
                                contentDescription = "product image",
                                modifier = Modifier.size(width = 230.dp, height = 180.dp)
                            )
                        }
                    }

                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                        ) {
                            Text(
                                "Bufect Strip of 4 Tablets -Heat and Pain Relief Medicine",
                                fontFamily = sora,
                                maxLines = 2,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )
                            Text(
                                "Per strip",
                                fontFamily = sora,
                                maxLines = 2,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )

                            Column {
                                Text(
                                    "Start from",
                                    fontFamily = sora,
                                    maxLines = 2,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.W400,
                                    color = Color(0xFF8F8F8F)
                                )
                                Text(
                                    "$2.00",
                                    fontFamily = sora,
                                    maxLines = 2,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF26408B)
                                )
                            }
                        }
                    }

                    item {
                        Spacer(Modifier.height(16.dp))

                        HorizontalDivider()

                        Spacer(Modifier.height(16.dp))

                    }

                    item {
                        ProductDescriptionSection("Product Description") {
                            Text(
                                "Bufect is a reliable and effective medication presented in a convenient strip containing four tablets. Each tablet is meticulously formulated to provide targeted relief from various ailments. With its user-friendly packaging and easy-to-carry design, Bufect ensures quick access to relief whenever and wherever needed. Trust Bufect for fast-acting and dependable relief from discomfort.",
                                fontFamily = sora,
                                style = TextStyle(
                                    lineHeight = 20.sp
                                ),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                    }

                    item {
                        ProductDescriptionSection("Benefits") {
                            BulletItem(
                                "Provides fast and effective relief from pain and discomfort"
                            )
                            BulletItem(
                                "Suitable for a wide range of ailments, including headaches, muscle aches, fever, and menstrual cramps."
                            )
                            BulletItem(
                                "Each tablet is individually sealed for freshness and potency."
                            )
                        }
                    }

                    item {
                        ProductDescriptionSection("Composition") {
                            BulletItem("Acetaminophen")
                            BulletItem("Ibuprofen")
                            BulletItem("Caffeine")
                        }
                    }

                    item {
                        ProductDescriptionSection("Dosage") {
                            BulletItem("Adults: Take 1 tablet every 4 to 6 hours as needed. Do not exceed 4 tablets in 24 hours.")
                            BulletItem("Children (ages 6-12): Take half a tablet every 4 to 6 hours as needed. Do not exceed 2 tablets in 24 hours")
                            BulletItem("Children under 6 years: Consult a healthcare professional before use.")
                        }
                    }

                    item {
                        ProductDescriptionSection("Storage Instructions") {
                            Text(
                                "For optimal potency and safety, it is recommended to store this medication in a cool, dry place, away from direct sunlight. Exposure to excessive heat or moisture may compromise the quality of the product. ",
                                fontFamily = sora,
                                style = TextStyle(
                                    lineHeight = 20.sp
                                ),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                    }

                    val reviewList = ServiceData.reviewList

                    item {
                        ProductDescriptionSection("Review") {
                            ReviewRow(reviewList)
                        }
                    }
                }
            }
      //  }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDescriptionSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            title,
            fontFamily = sora,
            maxLines = 2,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(Modifier.height(6.dp))

        content()
    }
}

@Composable
fun BulletItem(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "\u2022",
            fontSize = 22.sp,
            color = Color(0xFF26408B),
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = sora,
            lineHeight = 20.sp
        )
    }
}