package com.aarav.medcare.navigation

import com.aarav.medcare.R

sealed class NavItem(val name: String, val path: String, val icon: Int) {
    object Home : NavItem("Home", NavRoute.Home.path, R.drawable.home)
    object Services : NavItem("Services", NavRoute.Services.path, R.drawable.services)
    object History : NavItem("History", NavRoute.History.path, R.drawable.history)
    object Profile : NavItem("Profile", NavRoute.Profile.path, R.drawable.profile)

}