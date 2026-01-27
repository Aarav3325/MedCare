package com.aarav.medcare.services.shopping

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.Product
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    back: () -> Unit,
    onContinueClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Cart",
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
            )
        }
    ) {
        val productList = ServiceData.productList

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)

                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                ProfileCardCart()

//                if(productList.isEmpty()) {
                    Spacer(Modifier.height(24.dp))


                    productList.forEach { product ->
                        CartItem(product)
                    }

                    Spacer(Modifier.height(16.dp))

                    CouponSection()
//                }
            }

//            CartEmpty(modifier = Modifier.align(Alignment.Center))

//           if(productList.isEmpty()) {
               FilledTonalButton(
                   onClick = {
                       onContinueClick()
                   },
                   shape = RoundedCornerShape(24.dp),
                   modifier = Modifier
                       .padding(16.dp)
                       .fillMaxWidth()
                       .height(52.dp)
                       .align(Alignment.BottomCenter),
                   colors = ButtonDefaults.buttonColors(
                       contentColor = Color.White,
                       containerColor = Color(0xFF26408B)
                   )
               ) {
                   Text(
                       "Continue",
                       fontSize = 16.sp,
                       fontFamily = sora,
                       fontWeight = FontWeight.SemiBold
                   )
               }
           }
      //  }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardCart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        HorizontalDivider()

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(R.drawable.user1),
                    contentDescription = "user avatar",
                    modifier = Modifier.size(48.dp)
                )
            }


            Spacer(Modifier.width(12.dp))

            Text(
                "Delivery to Amy",
                fontSize = 14.sp,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(0.1f)
            )

            TextButton(
                contentPadding = PaddingValues(0.dp),
                onClick = {}
            ) {
                Text(
                    "Milan, Italy",
                    fontSize = 14.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF26408B)
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "down arrow",
                    tint = Color(0xFF26408B)
                )
            }
        }

        Spacer(Modifier.height(12.dp))


        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun CartItem(
    product: Product
) {
    Card(
        modifier = Modifier.padding(bottom = 12.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(product.productImage),
                contentDescription = "product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
            )

            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Text(
                    product.productName,
                    fontFamily = sora,
                    style = TextStyle(
                        lineHeight = 15.sp
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    "Per strip",
                    fontFamily = sora,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF8F8F8F)
                )

                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Start from",
                        fontFamily = sora,
                        maxLines = 1,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF8F8F8F)
                    )
                    Text(
                        "$${product.price}",
                        fontFamily = sora,
                        maxLines = 2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF26408B),
                        modifier = Modifier.weight(0.1f)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .border(
                                    1.dp, Color(0xFF26408B), RoundedCornerShape(6.dp)
                                ),
//                            .clickable {
//                                onDecrease()
//                            },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.minus),
                                contentDescription = "remove item",
                                modifier = Modifier.size(14.dp)
                            )
                        }


                        Text(
                            "1",
                            fontFamily = sora,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400
                        )

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .border(
                                    1.dp,
                                    Color(0xFF26408B),
                                    RoundedCornerShape(6.dp)
                                ),
//                            .clickable {
//                                onIncrease()
//                            },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.plus),
                                contentDescription = "remove item",
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CouponSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Have a coupon code? enter here",
            fontFamily = sora,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            color = Color.Black
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFFC2E7D9)),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    "2024CODE",
                    maxLines = 1,
                    fontFamily = sora,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.weight(0.1f)
                )

                TextButton(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        "Available",
                        fontSize = 14.sp,
                        fontFamily = sora,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF26408B)
                    )

                    Spacer(Modifier.width(4.dp))

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "down arrow",
                        tint = Color(0xFF26408B)
                    )
                }
            }
        }
    }
}

@Composable
fun CartEmpty(
    modifier: Modifier = Modifier
) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.cart_empty),
                contentDescription = "empty cart",
                modifier = Modifier.size(160.dp)
            )

            Text(
                "Oops! Your shopping cart is still empty",
                fontFamily = sora,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF4D4D4D)
            )
        }
}