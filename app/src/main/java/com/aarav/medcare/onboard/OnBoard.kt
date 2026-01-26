package com.aarav.medcare.onboard

import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun OnBoardScreen(
    navigateToRegister: () -> Unit
) {

    val pages = OnBoardContent.pages

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {
            pages.count()
        }
    )

    val isLastPage = pagerState.currentPage == pages.lastIndex

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(0.75f)
        ) { page ->
            OnBoardPage(onBoardingPage = pages[page])
        }

        val scope = rememberCoroutineScope()
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DotIndicator(
                pagerState.currentPage, pagerState.pageCount
            )

            FilledTonalButton(
                onClick = {
                    if(isLastPage) {
                        navigateToRegister()
                        Toast.makeText(context, "On Boarding Completed", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage + 1,
                                animationSpec = tween(500)
                            )
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF26408B)
                ),
                modifier = Modifier.padding(bottom = 36.dp).fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                val buttonText = if(!isLastPage) "Next" else "Start"

                Text(
                    text = buttonText,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DotIndicator(currentPage: Int, count: Int) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(count) { index ->

            val selected = if (currentPage == index) Color(0xFF26408B) else Color(0xFFC2E7D9)
            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp),
                color = selected
            ) {}
        }
    }
}