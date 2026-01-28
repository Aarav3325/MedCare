package com.aarav.medcare.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@Preview(showBackground = true)
@Composable
fun FilterChipsShopping(
    isSelected: Boolean,
    onClick: () -> Unit,
    label: String? = null,
    leadingIcon: Int? = null
) {

    var borderColor = if(isSelected) BorderStroke(2.dp, Color(0xFF26408B)) else BorderStroke(1.dp, Color(0xFFE3E3E3))
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        modifier = Modifier
            .wrapContentWidth()
            .height(40.dp)
            .padding(horizontal = 4.dp),
       // elevation = FilterChipDefaults.filterChipElevation(2.dp),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = Color.White,
            selectedLabelColor = Color(0xFF26408B),
            labelColor = Color(0xFF8F8F8F)
        ),
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = "filter",
                    tint = Color(0xFF121212),
                    modifier = Modifier.size(14.dp)
                )
            }
        },
        shape = RoundedCornerShape(6.dp),
        label = {
            label?.let {
                Text(
                    it,
                    fontSize = 14.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.W400
                )
            }
        },
        border = borderColor)
}

@Preview(showBackground = true)
@Composable
fun ArticleChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = isSelected,
        shape = RoundedCornerShape(24.dp),
        border = if (isSelected) null else BorderStroke(1.dp, Color(0xFFC2E7D9)),
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF26408B),
            selectedLabelColor = Color.White,
            containerColor = Color.White,
            labelColor = Color(0xFF8F8F8F)
        ),
        onClick = onClick,
        modifier = Modifier.wrapContentWidth().height(48.dp)
            .padding(8.dp),
        label = {
            Text(
                label,
                fontFamily = sora,
                fontSize = 12.sp,
                modifier = Modifier.wrapContentWidth(),
                fontWeight = if(isSelected) FontWeight.SemiBold else FontWeight.W400
            )
        }
    )
}


@Composable
fun TagChip(
    label: String
) {
    AssistChip(
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9)),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color.White,
            labelColor = Color(0xFF26408B)
        ),
        onClick = {},
        modifier = Modifier.wrapContentWidth().height(48.dp)
            .padding(8.dp),
        label = {
            Text(
                label,
                fontFamily = sora,
                color = Color(0xFF26408B),
                fontSize = 14.sp,
                modifier = Modifier.wrapContentWidth(),
                fontWeight = FontWeight.W400
            )
        }
    )
}