package com.aarav.medcare.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aarav.medcare.R
import com.aarav.medcare.ui.theme.sora

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ProfileScreen(
    back: () -> Unit,
    navController: NavController
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "My Profile",
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
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(bottom = 80.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            val menuGroup = ProfileData.menuGroup
            val generalInfoGroup = ProfileData.generalInfoGroup

            UserProfileCard()

            ProfileSettingsGroup(
                "Menu",
                menuGroup,
                false,
                navController
            )

            ProfileSettingsGroup(
                "General Information",
                generalInfoGroup,
                true,
                navController
            )

            FilledTonalButton(
                onClick = {},
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF9F3000)
                ),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color(0xFFC2E7D9))
            ) {
                Text(
                    "Log Out",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sora
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.user_avatar),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(80.dp)
                )

                Image(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(32.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    "Lorenzo Ricci",
                    fontSize = 16.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold,
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.email),
                        contentDescription = "email",
                    )

                    Text(
                        "lorenzoricci@example.com",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = sora,
                        color = Color(0xFF4D4D4D)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.phone),
                        contentDescription = "phone",
                        colorFilter = ColorFilter.tint(Color(0xFF4D4D4D)),
                        modifier = Modifier.size(15.dp)
                    )

                    Text(
                        "+39 1234567890",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = sora,
                        color = Color(0xFF4D4D4D)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileSettingsGroup(
    title: String,
    listOfItems: List<ProfileSettings>,
    switchItemEnabled: Boolean,
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            title,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontFamily = sora,
            color = Color(0xFF4D4D4D)
        )

        Spacer(Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                listOfItems.forEach { item ->
                    ProfileItem(item) {
                        item.path?.let {
                            navController.navigate(it)
                        }
                    }
                }

                if(switchItemEnabled) {
                    ProfileItemWithSwitch(
                        ProfileSettings(
                            R.drawable.dark_mode,
                            "Dark Mode",
                            "Set appearance to Dark or Light Theme"
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileItem(
    profileSettings: ProfileSettings,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .clickable {
                onClick()
            }
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(profileSettings.icon),
            contentDescription = "item icon"
        )

        Column {
            Text(
                profileSettings.label,
                fontSize = 16.sp,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
            )

            profileSettings.description?.let {
                Text(
                    it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileItemWithSwitch(
    profileSettings: ProfileSettings
) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(profileSettings.icon),
            contentDescription = "item icon"
        )

        Column(
            modifier = Modifier.weight(0.1f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                profileSettings.label,
                fontSize = 16.sp,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
            )

            profileSettings.description?.let {
                Text(
                    it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = sora,
                    color = Color(0xFF4D4D4D)
                )
            }
        }

        Switch(
            modifier = Modifier.padding(start = 4.dp),
            checked = isChecked,
            onCheckedChange = {
                isChecked = !isChecked
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color(0xFF26408B)
            )
        )
    }
}