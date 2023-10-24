package com.kusitms.presentation.navigation


//Main Route
sealed class NavRoutes(val route: String)
{
    object SplashScreen: NavRoutes("splash")
    object OpenScreen: NavRoutes("open")
    object LogInScreen: NavRoutes("login")
    object SignInScreen: NavRoutes("SignIn")
    object SignInScreen2: NavRoutes("SignIn2")
    object SignInScreen3: NavRoutes("SignIn2")
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



