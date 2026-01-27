package com.aarav.medcare.navigation

import com.aarav.medcare.R

sealed class NavItem(val name: String, val path: String, val icon: Int, val filledIcon: Int) {
    object Home : NavItem(
        "Home",
        NavRoute.Home.path,
        R.drawable.home,
        R.drawable.home_filled
    )
    object Services : NavItem(
        "Services",
        NavRoute.Services.path,
        R.drawable.services,
        R.drawable.services_filled
    )
    object History : NavItem(
        "History",
        NavRoute.History.path,
        R.drawable.history,
        R.drawable.history_filled
    )
    object Profile : NavItem(
        "Profile",
        NavRoute.Profile.path,
        R.drawable.profile,
        R.drawable.profile_filled
    )


}