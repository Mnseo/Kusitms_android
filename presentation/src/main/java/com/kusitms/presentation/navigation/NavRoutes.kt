package com.kusitms.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


//Main Route
sealed class NavRoutes(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    object SplashScreen: NavRoutes("splash")
    object LogInScreen: NavRoutes("login")

    object LoginNonMember: NavRoutes("loginNonMember")
    object LoginMemberScreen: NavRoutes("loginMember")

    object SignInDefault: NavRoutes("signInDefault")
    object SignInAdditionalProfile : NavRoutes("signInAdditionalProfile")
    object SignInProfileComplete: NavRoutes("signInProfileComplete")
    object SignInRequest: NavRoutes("signInRequest")

    object FindPwCheckEmail : NavRoutes("findPwCheckEmail")
    object FindPwCodeValidation : NavRoutes("findPwCodeValidation")
    object FindPwSetNewPw : NavRoutes(
        route = "findPwSetNewPW/isAsLoggedIn={isAsLoggedIn}",
        navArguments = listOf(
            navArgument("isAsLoggedIn"){
                type = NavType.BoolType
            }
        )
    ){
        fun createRoute(isAsLoggedIn: Boolean) = "findPwSetNewPW/isAsLoggedIn=${isAsLoggedIn}"
    }
    object FindPwMemberCurrent :NavRoutes("findPwMemberCurrent")


    object HomeScreen: NavRoutes("Home")
    object SettingMember: NavRoutes("SettingMember")
    object SettingNonMember: NavRoutes("SettingNonMember")

    object Notice : NavRoutes("Notice")

    object NoticeDetail : NavRoutes(
        route = "NoticeDetail/{noticeId}",
        navArguments = listOf(
            navArgument("noticeId"){
                type = NavType.IntType
            }
        )
    ){
        fun createRoute(noticeId: Int) = "NoticeDetail/${noticeId}"
    }

    object Profile : NavRoutes("Profile")

    object ProfileSearch : NavRoutes("ProfileSearch")

    object ProfileDetail : NavRoutes(
        route = "ProfileDetail/{profileId}",
        navArguments = listOf(
            navArgument("profileId"){
                type = NavType.IntType
            }
        )
    ) {
        fun createRoute(profileId: Int) = "ProfileDetail/${profileId}"
    }

    object ImageViewer : NavRoutes("ImageViewer")
}



//SignIn Route
sealed class SignInNavRoutes(val route: String)
{
    object SignInScreen1 : NavRoutes("signin1")
    object SignInScreen2 : NavRoutes("signin2")
    object SignInScreen3 : NavRoutes("signin3")
}