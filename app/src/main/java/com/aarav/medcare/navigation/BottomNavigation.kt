package com.aarav.medcare.navigation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aarav.medcare.ui.theme.sora

@Composable
fun BottomNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    val navItems = listOf(NavItem.Home, NavItem.Services, NavItem.History, NavItem.Profile)

    NavigationBar(
        tonalElevation = 4.dp,
        containerColor = Color.White,
        modifier = Modifier.shadow(24.dp)
    ) {
        navItems.forEachIndexed {
            index, item ->

            val isSelected = currentRoute?.startsWith(item.path) == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (currentRoute != item.path) {
                        navController.navigate(item.path) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }

                    }
                    Log.i("NAV", "BottomNavigationBar: $currentRoute, dest : ${item.path}")
                },
                label = {
                    Text(
                        item.name,
                        fontFamily = sora
                    )
                },
                icon = {
                    Image(painter = painterResource(item.icon),
                        contentDescription = "nav icon",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(if(isSelected) Color(0xFF26408B) else Color.Gray)
                       )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedTextColor = Color.Black,
                    unselectedTextColor = Color(0xFF8F8F8F),
                )
            )
        }
    }
}