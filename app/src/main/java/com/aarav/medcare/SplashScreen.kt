package com.aarav.medcare

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreen(
    navigateToHome: () -> Unit,
    navigateToOnBoard: () -> Unit,
) {

    LaunchedEffect(true) {
        delay(2000)
        navigateToHome()
    }

    Box(
        modifier = Modifier.background(Color(0xFF26408B)).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.medcare_logo),
            contentDescription = "logo",
            modifier = Modifier.size(172.dp)
        )
    }
}