package com.kusitms.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.*
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.ui.login.LoginScreen
import com.kusitms.presentation.ui.login.member.SignInDefaultProfile
import com.kusitms.presentation.ui.signIn.SignInAdditionalProfile
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import com.kusitms.presentation.model.login.LoginViewModel
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.model.setting.SettingViewModel
import com.kusitms.presentation.model.signIn.SignInRequestViewModel
import com.kusitms.presentation.ui.home.HomeScreen
import com.kusitms.presentation.ui.login.NonMemberScreen
import com.kusitms.presentation.ui.login.findPw.FindPwCheckEmail
import com.kusitms.presentation.ui.login.findPw.FindPwCodeValidation
import com.kusitms.presentation.ui.login.findPw.FindPwMemberCurrent
import com.kusitms.presentation.ui.login.findPw.FindPwSetNewPw
import com.kusitms.presentation.ui.login.member.LoginMemberScreen
import com.kusitms.presentation.ui.notice.NoticeScreen
import com.kusitms.presentation.ui.notice.detail.NoticeDetailScreen
import com.kusitms.presentation.ui.profile.ProfileScreen
import com.kusitms.presentation.ui.setting.SettingMember
import com.kusitms.presentation.ui.setting.SettingNonMember
import com.kusitms.presentation.ui.signIn.SignInProfileComplete
import com.kusitms.presentation.ui.signIn.SignInRequestScreen
import com.kusitms.presentation.ui.splash.SplashScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val findPwViewModel: FindPwViewModel=  hiltViewModel()
    val SettingViewModel : SettingViewModel = hiltViewModel()



    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route
    ) {
        kusitmsComposableWithAnimation(NavRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }

        //SignInScreen
        kusitmsComposableWithAnimation(NavRoutes.SignInDefault.route) { SignInDefaultProfile(SignInViewModel(), navController) }
        kusitmsComposableWithAnimation(NavRoutes.SignInAdditionalProfile.route) { SignInAdditionalProfile(navController) }
        kusitmsComposableWithAnimation(NavRoutes.SignInProfileComplete.route) { SignInProfileComplete(navController)}
        kusitmsComposableWithAnimation(NavRoutes.SignInRequest.route) { SignInRequestScreen(SignInRequestViewModel(), navController) }

        //LoginScreen
        kusitmsComposableWithAnimation(NavRoutes.LoginMemberScreen.route) {
            val loginViewModel: LoginViewModel = getViewModel()
            LoginMemberScreen(viewModel = loginViewModel, navController = navController)
        }
        kusitmsComposableWithAnimation(NavRoutes.LoginNonMember.route) { NonMemberScreen(navController) }
        kusitmsComposableWithAnimation(NavRoutes.LogInScreen.route) { LoginScreen(navController) }

        //FindPwScreen
        kusitmsComposableWithAnimation(NavRoutes.FindPwCheckEmail.route) { FindPwCheckEmail(navController, viewModel = findPwViewModel)}
        kusitmsComposableWithAnimation(NavRoutes.FindPwCodeValidation.route) { FindPwCodeValidation(navController, viewModel = findPwViewModel)}
        kusitmsComposableWithAnimation(NavRoutes.FindPwSetNewPw.route) { FindPwSetNewPw(navController, viewModel = findPwViewModel) }
        kusitmsComposableWithAnimation(NavRoutes.FindPwMemberCurrent.route) { FindPwMemberCurrent(navController)}

        //SettingScreen
        kusitmsComposableWithAnimation(NavRoutes.SettingMember.route) { SettingMember(navController, SettingViewModel)}
        kusitmsComposableWithAnimation(NavRoutes.SettingNonMember.route) { SettingNonMember(navController)}

        //HomeScreen
        kusitmsComposableWithAnimation(NavRoutes.HomeScreen.route) { HomeScreen(navController)}

        // NoticeScreen
        kusitmsComposableWithAnimation(NavRoutes.Notice.route) {
            NoticeScreen(
                onNoticeClick = {
                    navController.navigate(NavRoutes.NoticeDetail.createRoute(it.noticeId))
                },
                onSettingClick = {
                    navController.navigate(NavRoutes.SettingMember.route)
                }
            )
        }

        composable(
            route = NavRoutes.NoticeDetail.route,
            arguments = NavRoutes.NoticeDetail.navArguments
        ) {
            NoticeDetailScreen(
                onBack = {
                    navController.navigateUp()
                }
            )
        }

        kusitmsComposableWithAnimation(NavRoutes.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
inline fun <reified T: ViewModel> getViewModel() : T {
    return hiltViewModel()
}


fun NavGraphBuilder.kusitmsComposableWithAnimation(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
            animationSpec = tween(500)
        )
    },
    exitTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
            animationSpec = tween(700)
        )
    },
    popEnterTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        enterTransition,
    popExitTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? =
        exitTransition,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route,
        arguments,
        deepLinks,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition,
        content
    )
}

