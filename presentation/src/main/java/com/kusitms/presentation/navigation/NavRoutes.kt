package com.kusitms.presentation.navigation


//Main Route
sealed class NavRoutes(val route: String)
{
    object Splash: NavRoutes("splash")

    object Login: NavRoutes("login")

    object SignIn: NavRoutes("SignIn")
    object Home: NavRoutes("home")
    object Setting: NavRoutes("setting")

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

