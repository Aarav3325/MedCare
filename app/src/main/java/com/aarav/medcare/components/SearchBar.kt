package com.aarav.medcare.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.services.Article
import com.aarav.medcare.services.ServiceData
import com.aarav.medcare.services.article.ArticleCard
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarHome(
    expanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
) {
    SearchBar(
        modifier = Modifier.padding(horizontal = 16.dp),
        inputField = {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.height(56.dp),
                placeholder = {
                    Text(
                        "Find a doctor, medicine or health services",
                        color = Color.Gray,
                        fontFamily = sora
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF9F9F9),
                    unfocusedIndicatorColor = Color(0xFFC2E7D9),
                    unfocusedLeadingIconColor = Color.Gray
                ),
                trailingIcon = {

                    Icon(
                        painter = painterResource(R.drawable.mi_filter),
                        contentDescription = "filter",
                        modifier = Modifier.size(20.dp)
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.mingcute_search_line),
                        contentDescription = "search",
                        modifier = Modifier.size(20.dp)
                    )
                }
            )
        },
        expanded = expanded,
        onExpandedChange = onExpandChange,
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarChatDoctor(
    expanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
) {
    SearchBar(
        windowInsets = WindowInsets(0.dp),
        colors = SearchBarDefaults.colors(
            containerColor = Color(0xFFF9F9F9)
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(56.dp),
        inputField = {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(
                        "Find a doctor",
                        color = Color.Gray,
                        fontFamily = sora
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = Color(0xFFF9F9F9),
                    unfocusedIndicatorColor = Color(0xFFC2E7D9),
                    unfocusedLeadingIconColor = Color.Gray
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.mingcute_search_line),
                        contentDescription = "search",
                        modifier = Modifier.size(20.dp)
                    )
                }
            )
        },
        expanded = expanded,
        onExpandedChange = onExpandChange,
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarShopping(
    expanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
) {
    SearchBar(
        windowInsets = WindowInsets(0.dp),
        colors = SearchBarDefaults.colors(
            containerColor = Color(0xFFF9F9F9)
        ),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .height(48.dp),
        inputField = {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                placeholder = {
                    Text(
                        "Search a product or store",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontFamily = sora
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = Color(0xFFF9F9F9),
                    unfocusedIndicatorColor = Color(0xFFC2E7D9),
                    unfocusedLeadingIconColor = Color.Gray
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.mingcute_search_line),
                        contentDescription = "search",
                        modifier = Modifier.size(20.dp)
                    )
                }
            )
        },
        expanded = expanded,
        onExpandedChange = onExpandChange,
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarArticle(
    expanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
    filteredList: List<Article>
) {
    SearchBar(
        expanded = expanded,
        shape = RoundedCornerShape(12.dp),
        onExpandedChange = onExpandChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp), // ❌ no height here
        windowInsets = WindowInsets(0),
        colors = SearchBarDefaults.colors(
            containerColor = Color(0xFFF9F9F9)
        ),
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = {},
                expanded = expanded,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFFC2E7D9), RoundedCornerShape(12.dp)),
                onExpandedChange = onExpandChange,
                placeholder = {
                    Text(
                        "Search a product or store",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontFamily = sora
                    )
                },
                leadingIcon = {
                    if(!expanded) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.mingcute_search_line),
                                contentDescription = "search",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    else {
                        IconButton(
                            onClick = {
                                onExpandChange(false)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "search",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = Color(0xFFF9F9F9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )
        }
    ) {
        if (expanded) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                filteredList.forEach { article ->
                    ArticleCard(article)
                }
            }

        }
    }
}
