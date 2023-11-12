package com.kusitms.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable


//Main Route
sealed class NavRoutes(val route: String)
{
    object SplashScreen: NavRoutes("splash")
    object OpenScreen: NavRoutes("open")
    object LogInScreen: NavRoutes("login")

    object LoginNonMember: NavRoutes("loginNonMember")
    object LoginMember: NavRoutes("loginMember")

    object SignInScreen: NavRoutes("signin")

    object Home: NavRoutes("Home")
    object Setting: NavRoutes("Setting")

}


//Login Route
sealed class LoginNavRoutes(val route: String)
{
    object LoginWithMember : NavRoutes("loginMember")
    object LoginWithManager : NavRoutes("loginManager")
    object LoginNonMember : NavRoutes ("loginNonMember")
}

//SignIn Route
sealed class SignInNavRoutes(val route: String)
{
    object SignIn1 : NavRoutes("signin1")
    object SignIn2 : NavRoutes("signin2")
    object SignIn3 : NavRoutes("signin3")
}