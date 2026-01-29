package com.aarav.medcare.services.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora
import androidx.compose.ui.res.stringResource
import com.aarav.medcare.components.TagChip

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ArticleDetailScreen(
    back: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            back()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "arrow"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Getting to know Hanta Virus Disease from Rodents",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                fontFamily = sora,
                color = Color.Black
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Written by Lonard on January 10, 2024",
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                fontFamily = sora,
                color = Color(0xFF8f8f8f)
            )


            Spacer(Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(12.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.article_header),
                    contentDescription = "header image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                )
            }

            Spacer(Modifier.height(16.dp))


            Text(
                stringResource(R.string.article_description),
                fontWeight = FontWeight.W400,
                fontFamily = sora,
                fontSize = 14.sp,
                color = Color(0xFF8f8f8f)
            )

            Spacer(Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                TagChip("Content-Healthy")
                TagChip("Healthcare")
                TagChip("Healthy-environment")
            }
        }
    }
}
