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
    object LoginMemberScreen: NavRoutes("loginMember")

    object SignInScreen: NavRoutes("signin")
    object SignInScreen2 : NavRoutes("signin2")
    object SignInScreen3 : NavRoutes("signin3")

    object FindPwScreen1 : NavRoutes("findpw1")
    object FindPwScreen2 : NavRoutes("findpw1")


    object Home: NavRoutes("Home")
    object Setting: NavRoutes("Setting")

}



//SignIn Route
sealed class SignInNavRoutes(val route: String)
{
    object SignInScreen1 : NavRoutes("signin1")
    object SignInScreen2 : NavRoutes("signin2")
    object SignInScreen3 : NavRoutes("signin3")
}