package com.kusitms.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable


//Main Route
sealed class NavRoutes(val route: String)
{
    object SplashScreen: NavRoutes("splash")
    object LogInScreen: NavRoutes("login")

    object LoginNonMember: NavRoutes("loginNonMember")
    object LoginMemberScreen: NavRoutes("loginMember")

    object SignInDefault: NavRoutes("signInDefault")
    object SignInAdditionalProfile : NavRoutes("signInAdditionalProfile")
    object SignInProfileComplete: NavRoutes("signInProfileComplete")

    object FindPwCheckEmail : NavRoutes("findPwCheckEmail")
    object FindPwCodeValidation : NavRoutes("findPwCodeValidation")
    object FindPwSetNewPw : NavRoutes("findPwSetNewPW")


    object HomeScreen: NavRoutes("Home")
    object Setting: NavRoutes("Setting")

}



//SignIn Route
sealed class SignInNavRoutes(val route: String)
{
    object SignInScreen1 : NavRoutes("signin1")
    object SignInScreen2 : NavRoutes("signin2")
    object SignInScreen3 : NavRoutes("signin3")
}