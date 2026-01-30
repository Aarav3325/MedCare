package com.aarav.medcare.services.chatdoctor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.Chat
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@Composable
fun ChatScreen(
    back: () -> Unit,
    navigateToVideoCall: () -> Unit,
    navigateToCall: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(top = 52.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(bottom = 80.dp)
            ) {
                stickyHeader {
                    Box() {
                        Row(
                            modifier = Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "arrow",
                                modifier = Modifier.clickable {
                                    back()
                                }
                            )

                            Spacer(Modifier.width(12.dp))

                            Image(
                                painter = painterResource(R.drawable.doctor6),
                                contentDescription = "avatar",
                                modifier = Modifier.size(44.dp)
                            )

                            Spacer(Modifier.width(12.dp))

                            Column(
                                modifier = Modifier.weight(0.1f)
                            ) {
                                Text(
                                    "Dr. Giovanni Bianchi",
                                    maxLines = 1,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = sora
                                )

                                Text(
                                    "General Surgery",
                                    fontSize = 12.sp,
                                    color = Color(0xFF4D4D4D),
                                    fontWeight = FontWeight.W400,
                                    fontFamily = sora
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(R.drawable.video),
                                        contentDescription = "video",
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clickable {
                                                navigateToVideoCall()
                                            }
                                    )
                                }

                                Box {
                                    Image(
                                        painter = painterResource(R.drawable.phone),
                                        contentDescription = "phone",
                                        colorFilter = ColorFilter.tint(Color(0xFF8F8F8F)),
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clickable {
                                                navigateToCall()
                                            }
                                    )
                                }
                            }
                        }
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 84.dp)
                        ) {
                            Text(
                                "Today",
                                fontFamily = sora,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF4D4D4D),
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 24.dp)
                            )
                        }
                    }
                }

                val chats = ServiceData.chats

                items(chats) { chat ->
                    ChatBubble(chat)
                }
            }
        }

        TextTypeBox(
            Modifier.align(Alignment.BottomCenter)
        )

//
//        Column(
//            modifier = Modifier.fillMaxWidth()
//                .verticalScroll(rememberScrollState())
//        ) {
//            ChatBubble(true)
//            ChatBubble(false)
//            ChatBubble(true)
//            ChatBubble(false)
//        }


    }
}

@Preview(showBackground = true)
@Composable
fun ChatBubble(
    chat: Chat
) {
    val bg = if (chat.sent) Color(0xFF26408B) else Color.White
    val content = if (chat.sent) Color.White else Color.Black
    val alignment = if (chat.sent) Alignment.End else Alignment.Start

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = alignment,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 12.dp,
                bottomStart = 12.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = bg,
                contentColor = content
            )
        ) {
            Text(
                chat.message,
                fontFamily = sora,
                fontSize = 16.sp,
                style = TextStyle(
                    lineHeight = 22.sp
                ),
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(16.dp)
            )
        }

        Text(
            "09:32 PM",
            fontFamily = sora,
            color = Color(0xFF4D4D4D),
            fontWeight = FontWeight.W400,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextTypeBox(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = "",
            onValueChange = {

            },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFFFAFAFA),
                focusedContainerColor = Color(0xFFFAFAFA)
            ),
            placeholder = {
                Text(
                    "Type here...",
                    fontFamily = sora,
                    fontSize = 12.sp,
                    color = Color(0xFF8F8F8F)
                )
            },
            trailingIcon = {
                Row(
                    modifier = Modifier.padding(end = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    VerticalDivider(
                        modifier = Modifier
                            .width(2.dp)
                            .height(28.dp)
                    )

                    Icon(
                        painter = painterResource(R.drawable.sticker),
                        contentDescription = "sticker",
                        tint = Color(0xFF8F8F8F),
                        modifier = Modifier.size(24.dp)
                    )

                    Icon(
                        painter = painterResource(R.drawable.camera_chat),
                        contentDescription = "sticker",
                        tint = Color(0xFF8F8F8F),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )
    }
}
