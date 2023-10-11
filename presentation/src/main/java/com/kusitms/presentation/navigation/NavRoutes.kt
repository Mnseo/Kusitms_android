package com.kusitms.presentation.navigation


//Main Route
sealed class NavRoutes(val route: String)
{
    object SplashScreen: NavRoutes("splash")
    object OpenScreen: NavRoutes("open")
    object LoginScreen: NavRoutes("login")

    object SignIn: NavRoutes("SignIn")
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

sealed class SignInRoutes(val route: String)
{

}

