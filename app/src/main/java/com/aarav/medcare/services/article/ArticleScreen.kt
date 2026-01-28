package com.aarav.medcare.services.article

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.components.ArticleChip
import com.aarav.medcare.components.SearchBarArticle
import com.aarav.medcare.services.Article
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

enum class ArticleChips(val label: String) {
    ALL("All Articles"),
    ADULTS("Adults"),
    INFANTS_AND_TODDLERS("Infants & Toddlers"),
    CHILDREN("Children")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ArticleScreen() {

    var isExpanded by remember {
        mutableStateOf(false)
    }

//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Box(
//                            modifier = Modifier.clickable {
//
//                            }
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.KeyboardArrowLeft,
//                                contentDescription = "back arrow",
//                                tint = Color(0xFF4D4D4D),
//                                modifier = Modifier.size(24.dp)
//                            )
//                        }
//
//                    }
//                }
//            )
//        }
//    ) {
    var selectedChip by remember {
        mutableStateOf<ArticleChips>(ArticleChips.ALL)
    }

    val articleList = ServiceData.articleList

    val pagerState = rememberPagerState(
        initialPage = 1,
        pageCount = {
            articleList.count()
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 52.dp)
    ) {
        val latestArticle = ServiceData.latestArticle
        var expanded by remember { mutableStateOf(false) }

        var query by remember {
            mutableStateOf("")
        }

        val filteredList by remember {
            derivedStateOf {
                if (query.isBlank()) latestArticle
                else latestArticle.filter {
                    it.title.contains(query, ignoreCase = true)
                }
            }
        }


        Log.i("MYTAG", "expanded: $query")


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(!expanded) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back arrow",
                        tint = Color(0xFF4D4D4D),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            SearchBarArticle(
                expanded = expanded,
                onExpandChange = { expanded = it },
                query = query,
                onQueryChange = { query = it },
                filteredList = filteredList
            )
        }

        LazyColumn(
            modifier = Modifier
        ) {
            item {


                Text(
                    "Hot Article",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )

                HorizontalPager(
                    state = pagerState,
                    snapPosition = SnapPosition.Start,
                    pageSpacing = 12.dp,
                    modifier = Modifier.padding(vertical = 0.dp),
                    contentPadding = PaddingValues(horizontal = 32.dp),
                ) { page ->
                    ArticleCarouselItem(articleList[page])
                }
            }

            item {
                Text(
                    "Hot Topic",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )

                val hotTopicList = ServiceData.hotTopicList

                LazyRow(
                    modifier = Modifier.padding(start = 8.dp),
                ) {
                    items(
                        hotTopicList
                    ) { topic ->
                        HotTopicCard(topic)
                    }
                }
            }


            item {

                Text(
                    "Latest Article",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                ArticleChipRow(
                    selectedChip
                ) {
                    selectedChip = it
                }
            }

            item {
                val latestArticle = ServiceData.latestArticle

                latestArticle.forEach { article ->
                    ArticleCard(article)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleCarouselItem(article: Article) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.2f),
                            Color.Black.copy(alpha = 0.2f)
                        ),
                    ),
                )
        ) {
            Image(
                painter = painterResource(article.image),
                contentDescription = "article image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )


            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    article.title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )

                FilledTonalButton(
                    shape = RoundedCornerShape(4.dp),
                    onClick = {},
                    contentPadding = PaddingValues(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF26408B)
                    )
                ) {
                    Text(
                        "Read Article",
                        fontSize = 10.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun HotTopicCard(
    topic: Pair<String, Int>
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .size(width = 160.dp, height = 80.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(topic.second),
                contentDescription = "topic image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            Text(
                topic.first,
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun ArticleChipRow(
    selectedChip: ArticleChips,
    onClick: (ArticleChips) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()
    ) {
        items(ArticleChips.entries.toList()) { chips ->
            ArticleChip(
                chips.label,
                isSelected = chips == selectedChip
            ) {
                onClick(chips)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleCard(
    article: Article
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        androidx.compose.material3.Surface(
            shape = RoundedCornerShape(6.dp)
        ) {
            Image(
                painter = painterResource(article.image),
                contentDescription = "article image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp, 60.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                article.tag?.label ?: "",
                fontSize = 10.sp,
                fontFamily = sora,
                fontWeight = FontWeight.W400,
                color = Color(0xFF8F8F8F)
            )
            Text(
                article.title,
                fontSize = 14.sp,
                fontFamily = sora,
                fontWeight = FontWeight.W400,
                color = Color.Black
            )
        }
    }
}