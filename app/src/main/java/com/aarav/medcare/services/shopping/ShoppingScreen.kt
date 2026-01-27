package com.aarav.medcare.services.shopping

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.components.CartBottomSheet
import com.aarav.medcare.components.CustomButtonSheets
import com.aarav.medcare.components.FilterChipsShopping
import com.aarav.medcare.components.SearchBarShopping
import com.aarav.medcare.services.BrandDetails
import com.aarav.medcare.services.Product
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.ui.theme.sora

enum class ShoppingFilters(val label: String) {
    MEDICINE_TREATMENT("Milk & Treatments"),
    MILK("Milk"),
    SEXUAL_HEALTH("Sexual Health")
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingScreen(
    navigateToCart: () -> Unit,
    navigateToDetail: () -> Unit,
    back: () -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(bottom = 8.dp),
                title = {
                    SearchBarShopping(expanded) {
                        expanded = !expanded
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { back() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "back arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        navigateToCart()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.solar_cart_3_outline),
                            contentDescription = "cart icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) {

        var selectedFilter by remember {
            mutableStateOf<ShoppingFilters?>(null)
        }

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(vertical = 12.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.KeyboardArrowLeft,
//                contentDescription = "back arrow",
//                modifier = Modifier.size(24.dp)
//            )
//
//            SearchBarShopping(expanded) {
//                expanded = !expanded
//            }
//
//            Icon(
//                painter = painterResource(R.drawable.solar_cart_3_outline),
//                contentDescription = "cart icon",
//                modifier = Modifier.size(24.dp)
//            )
//        }
//
            Spacer(Modifier.height(8.dp))

            FilterRow(selectedFilter) {
                selectedFilter = it
            }

            Spacer(Modifier.height(16.dp))


            val productList = ServiceData.productList

            selectedFilter?.let {
                ProductColumnLayout(productList, navigateToDetail)
            }
                ?: Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    OfficialStoreHeader()



                    SalesSection(
                        navigateToDetail,
                        productList,
                        "Hot Sales",
                        Modifier.padding(16.dp)
                    )

                    SalesSection(
                        navigateToDetail,
                        productList,
                        "Recently Viewed",
                        Modifier.padding(16.dp)
                    )
                }
        }
    }
}

@Composable
fun SalesSection(
    onClick: () -> Unit,
    itemList: List<Product>,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                title,
                fontFamily = sora,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                "See all",
                fontFamily = sora,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF26408B)
            )

        }

        LazyRow(
            modifier = Modifier.padding(start = 0.dp)
        ) {
            items(itemList) { product ->
                ProductLayout(product, onClick)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterRow(
    selectedFilter: ShoppingFilters?,
    onFilterSelected: (ShoppingFilters) -> Unit
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        item {
            FilterChip(
                selected = false,
                onClick = { },
                shape = RoundedCornerShape(6.dp),
                elevation = FilterChipDefaults.filterChipElevation(2.dp),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.White,
                    selectedLabelColor = Color(0xFF26408B),
                    labelColor = Color(0xFF8F8F8F)
                ),
                label = {
                    Icon(
                        painter = painterResource(R.drawable.mi_filter),
                        contentDescription = "filter",
                        tint = Color(0xFF121212),
                        modifier = Modifier.size(14.dp)
                    )
                },
            )
        }

        items(ShoppingFilters.entries.toList()) { filters ->
            FilterChipsShopping(
                isSelected = selectedFilter == filters,
                onClick = {
                    onFilterSelected(filters)
                },
                label = filters.label
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OfficialStoreHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFC2E7D9))
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "Official Store",
                    fontFamily = sora,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    "Special offers from various renowned brands",
                    fontFamily = sora,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }


            Text(
                "See all",
                fontFamily = sora,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF26408B),
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Spacer(Modifier.height(16.dp))


        val brandList = ServiceData.brandStore

        LazyRow(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            items(brandList) { brand ->
                BrandStore(brand)
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun BrandStore(
    brand: BrandDetails
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(end = 8.dp)
            .size(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF8F8F8F)
        )
    ) {
        Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color.White,
            modifier = Modifier.padding(
                vertical = 18.dp, horizontal = 18.dp
            )
        ) {
            Box(
                contentAlignment = Alignment
                    .Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(brand.logo),
                    contentDescription = "brand image",
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ProductLayout(
    product: Product,
    onClick: () -> Unit
) {

    var count by remember {
        mutableIntStateOf(0)
    }

    var showModal by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    if (showModal) {
        CustomButtonSheets(
            sheetState,
            onDismiss = { showModal = false },
        ) {
            CartBottomSheet(
                product,
                count,
                onDismiss = { showModal = false },
                onDecrease = {
                    if (count > 0) {
                        count -= 1
                    }
                    if (count == 0) {
                        showModal = false
                    }
                },
                onIncrease = {
                    count += 1
                }
            )
        }
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable {
                onClick()
            }
            .width(170.dp)
            .height(258.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column() {
                Image(
                    painter = painterResource(product.productImage),
                    contentDescription = "product image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                )

                Column(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                ) {
                    Text(
                        product.productName,
                        fontFamily = sora,
                        style = TextStyle(
                            lineHeight = 15.sp
                        ),
                        maxLines = 2,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(
                        product.supporting,
                        fontFamily = sora,
                        maxLines = 1,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF8F8F8F)
                    )
                }

            }

            Spacer(Modifier.height(24.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
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
                        color = Color(0xFF26408B)
                    )
                }

                FilledTonalButton(
                    onClick = {
                        showModal = true
                        count++
                    },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .height(32.dp)
                        .weight(1.2f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF26408B)
                    ),
                    shape = RoundedCornerShape(24.dp),
                    border = BorderStroke(1.dp, Color(0xFF26408B))
                ) {
                    Text(
                        "Add",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF26408B)
                    )
                }
            }
        }

    }
}

@Composable
fun ProductColumnLayout(
    productList: List<Product>,
    onClick: () -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = 8.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(productList) { product ->
            ProductLayout(product, onClick)
        }
    }
}