package com.aarav.medcare.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aarav.medcare.R
import com.aarav.medcare.components.HeaderHome
import com.aarav.medcare.components.SearchBarHome
import com.aarav.medcare.components.ServicesGrid
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val lazyState = rememberLazyListState()

    var expanded by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Hi, ",
                            fontSize = 20.sp
                        )
                        Text(
                            "Alex",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.padding(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.solar_cart_3_outline),
                            contentDescription = "cart",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.solar_bell_bing_outline),
                            contentDescription = "bell",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(bottom = 80.dp)
                .verticalScroll(rememberScrollState())
        ) {
            HeaderHome()

            SearchBarHome(
                expanded
            ) {
                expanded = !expanded
            }

            ServicesGrid(HomeGridData.serviceList, navController)

            Card(
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, Color(0xFFC2E7D9))
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(0.1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Consultation with a specialist",
                            fontFamily = sora,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            "Promote health via chat or call",
                            fontFamily = sora,
                            fontWeight = FontWeight.W400,
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "right arrow",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }

            ChatDoctorSection()

            BestSellingProductsSection()

            HospitalSection()

            ArticleSection()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatDoctorSection() {

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {
            HomeGridData.DoctorList.count()
        }
    )

    val pages = HomeGridData.DoctorList

    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Text(
            text = "Chat Doctor",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontFamily = sora,
            modifier = Modifier
        )

        HorizontalUncontainedCarousel(
            state = rememberCarouselState { pages.count() },
            modifier = Modifier.wrapContentHeight(),
            itemWidth = 160.dp,
            itemSpacing = 8.dp,
        ) {
                page ->
            DoctorCard(pages[page])
        }
    }
}

@Composable
fun DoctorCard(doctor: Doctor) {
    Card(
        modifier = Modifier.size(160.dp),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9)),
        shape = RoundedCornerShape(12.dp),
    ) {
        Box(
        ){
            Image(
                painter = painterResource(doctor.image),
                contentDescription = "doctor image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.padding(4.dp).align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = doctor.name,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = sora
                )
                Text(
                    text = doctor.type,
                    color = Color(0xFFC2E7D9),
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = sora
                )
            }
        }
    }
}

@Composable
fun BestSellingProductsSection() {
    val productList = listOf(R.drawable.vaccine, R.drawable.braces, R.drawable.wheelchair, R.drawable.mask, R.drawable.vaccine)

    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Best Selling Products",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontFamily = sora,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )

        LazyRow(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            items(productList) {
                image -> ProductLayout(image)
            }
        }
    }
}

@Composable
fun HospitalSection() {

    val hospitalList = HomeGridData.hospitalList
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Nearby Hospitals",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontFamily = sora,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )

        LazyRow(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            items(hospitalList) {
                    item -> HospitalCard(item)
            }
        }
    }
}


@Composable
fun ArticleSection() {

    val articleList = HomeGridData.articleList
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Health Article",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontFamily = sora,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )

        Column(
            modifier = Modifier
        ) {
            articleList.forEach {
                    article -> ArticleLayout(article)
            }
        }
    }
}

@Composable
fun ProductLayout(image: Int) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.padding(end = 8.dp).size(82.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "product image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HospitalCard(hospital: Hospital) {
    Card(
        modifier = Modifier.padding(end = 8.dp).size(180.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(0.dp),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9))
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.ellipse_hospital_card),
                contentDescription = "ellipse",
                modifier = Modifier.align(Alignment.TopEnd)
                    .size(60.dp),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.align(Alignment.CenterStart).padding(12.dp)
            ) {
                Image(
                    painter = painterResource(hospital.image),
                    contentDescription = "hospital logo",
                    modifier = Modifier.size(width = 60.dp, height = 38.dp)
                )

                Text(
                    text = hospital.name,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFF26408B),
                    maxLines = 3
                )
            }

            TextButton(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 12.dp, start = 12.dp, top = 8.dp).height(28.dp)
                    .align(Alignment.BottomStart),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    "See maps",
                    fontFamily = sora,
                    color = Color.Gray
                )

                Spacer(Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "null",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleLayout(article: Article) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(article.image),
            contentDescription = "article image",
            modifier = Modifier.size(88.dp)
        )

        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                article.tag,
                fontWeight = FontWeight.SemiBold,
                fontFamily = sora,
                color = Color(0xFF4D4D4D),
                fontSize = 12.sp
            )

            Text(
                article.title,
                fontWeight = FontWeight.Normal,
                fontFamily = sora,
                style = TextStyle(
                    lineHeight = 20.sp
                ),
                color = Color.Black,
                maxLines = 2,
                fontSize = 16.sp
            )

            Text(
                article.date,
                fontWeight = FontWeight.W400,
                fontFamily = sora,
                color = Color(0xFF4D4D4D),
                fontSize = 10.sp
            )
        }
    }
}
