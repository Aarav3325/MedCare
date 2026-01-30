package com.aarav.medcare.services.chatdoctor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@Composable
fun VideoCallScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(0xFF06010E))
                )
            )

    ) {


        Image(
            painter = painterResource(R.drawable.video_call1),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )


            Text(
                "10:30 mins",
                fontFamily = sora,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 108.dp)
            )

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Surface(
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.video_call2),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(120.dp)
                        .height(160.dp)

                )
            }


            CallActionRow(
                modifier = Modifier
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun CallActionRow(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .background(Color.Transparent)
            .padding(vertical = 24.dp, horizontal = 42.dp)
            .fillMaxWidth()
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFFAAAAAA),
            modifier = Modifier
                .blur(1.dp)
                .size(72.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.speaker),
                contentDescription = "speaker",
                modifier = Modifier
                    .padding(20.dp)
                    .size(24.dp)
            )
        }

        Surface(
            shape = CircleShape,
            color = Color(0xFFAAAAAA),
            modifier = Modifier
                .blur(1.dp)
                .size(72.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.microphone),
                contentDescription = "speaker",
                modifier = Modifier
                    .padding(20.dp)
                    .size(24.dp)
            )
        }

        Surface(
            shape = CircleShape,
            color = Color(0xFFF00000),
            modifier = Modifier
                .blur(1.dp)
                .size(72.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.hang_up),
                contentDescription = "speaker",
                modifier = Modifier
                    .padding(20.dp)
                    .size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color.Transparent, Color(0xFF06010E))
                )
            )
    ) {}
}