package com.aarav.medcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@Composable
fun HeaderHome() {
    Box(
        modifier = Modifier.fillMaxWidth().height(210.dp)
            .background(
                brush = Brush.linearGradient(
                    listOf(Color(0xFF2A083B), Color(0xFF152A65))
                )
            )
    ){
        Image(
            painter = painterResource(R.drawable.ellipase_home2),
            contentDescription = "ellipse",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 54.dp, height = 64.dp)
        )

        Image(
            painter = painterResource(R.drawable.ellipase_home1),
            contentDescription = "ellipse",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth(0.25f)
                .fillMaxHeight(0.8f).align(Alignment.TopEnd)
        )

        Image(
            painter = painterResource(R.drawable.home_illustration),
            contentDescription = "ellipse",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 162.dp, height = 154.dp)
                .align(Alignment.BottomEnd)
        )

        Column(
            modifier = Modifier.align(
                Alignment.CenterStart
            )
                .padding(start = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Experience Seamless\nHealthcare Management\nwith MediConnect",
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            FilledIconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFF26408B),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.width(148.dp).height(36.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.wrapContentHeight().padding(8.dp)
                ) {
                    Text(
                        "Fill Your Profile Now!",
                        fontFamily = sora,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 0.dp).wrapContentHeight()
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "arrow right",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp).padding(bottom = 0.dp)
                    )
                }
            }
        }

    }
}