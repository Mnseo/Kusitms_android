package com.kusitms.presentation.navigation

sealed class NavRoutes(val route: String)
{
    object Splash: NavRoutes("splash")
    object Login: NavRoutes("login")
    object Onboarding: NavRoutes("onboarding")
    object Home: NavRoutes("home")
    object Setting: NavRoutes("setting")

}