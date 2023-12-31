package com.kusitms.presentation.navigation

import ProfileDetailScreen
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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.login.LoginViewModel
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.model.setting.SettingViewModel
import com.kusitms.presentation.model.signIn.SignInRequestViewModel
import com.kusitms.presentation.model.signIn.SplashViewModel
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
import com.kusitms.presentation.ui.profile.search.ProfileSearchScreen
import com.kusitms.presentation.ui.setting.SettingMember
import com.kusitms.presentation.ui.setting.SettingNonMember
import com.kusitms.presentation.ui.signIn.SignInProfileComplete
import com.kusitms.presentation.ui.signIn.SignInRequestScreen
import com.kusitms.presentation.ui.splash.SplashScreen
import com.kusitms.presentation.ui.viewer.ImageViewerScreen
import com.kusitms.presentation.ui.viewer.ImageViewerViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val findPwViewModel: FindPwViewModel = hiltViewModel()
    val SettingViewModel: SettingViewModel = hiltViewModel()
    val signInViewModel: SignInViewModel = hiltViewModel()
    val signInReqeustViewModel: SignInRequestViewModel = hiltViewModel()
    val imageViewerViewModel: ImageViewerViewModel = hiltViewModel()
    val splashViewModel: SplashViewModel = hiltViewModel()
    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(
        snackbarHost = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 66.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                SnackbarHost(hostState = snackbarHostState)
            }

        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.SplashScreen.route,
            modifier = Modifier.background(color = KusitmsColorPalette.current.Grey900),
        ) {
            kusitmsComposableWithAnimation(NavRoutes.SplashScreen.route) {
                SplashScreen(splashViewModel,navController)
            }

            kusitmsComposableWithAnimation(NavRoutes.SignInDefault.route) { SignInDefaultProfile(signInViewModel, navController) }
            kusitmsComposableWithAnimation(NavRoutes.SignInAdditionalProfile.route) { SignInAdditionalProfile(signInViewModel, navController) }
            kusitmsComposableWithAnimation(NavRoutes.SignInProfileComplete.route) { SignInProfileComplete(signInViewModel, navController)}
            kusitmsComposableWithAnimation(NavRoutes.SignInRequest.route) { SignInRequestScreen(signInReqeustViewModel, navController) }

            //LoginScreen
            kusitmsComposableWithAnimation(NavRoutes.LoginMemberScreen.route) {
                val loginViewModel: LoginViewModel = getViewModel()
                LoginMemberScreen(viewModel = loginViewModel, navController = navController)
            }
            kusitmsComposableWithAnimation(NavRoutes.LoginNonMember.route) {
                NonMemberScreen(
                    navController
                )
            }
            kusitmsComposableWithAnimation(NavRoutes.LogInScreen.route) { LoginScreen(navController) }

            //FindPwScreen
            kusitmsComposableWithAnimation(NavRoutes.FindPwCheckEmail.route) {
                FindPwCheckEmail(
                    navController,
                    viewModel = findPwViewModel
                )
            }
            kusitmsComposableWithAnimation(
                NavRoutes.FindPwCodeValidation.route
            ) {
                FindPwCodeValidation(
                    navController,
                    viewModel = findPwViewModel
                )
            }
            kusitmsComposableWithAnimation(
                NavRoutes.FindPwSetNewPw.route,
                arguments = NavRoutes.FindPwSetNewPw.navArguments
            ) {
                FindPwSetNewPw(navController)
            }

            kusitmsComposableWithAnimation(
                NavRoutes.FindPwMemberCurrent.route
            ) {
                FindPwMemberCurrent(navController)
            }

            //SettingScreen
            kusitmsComposableWithAnimation(NavRoutes.SettingMember.route) {
                SettingMember(
                    navController = navController,
                    viewModel = SettingViewModel
                )
            }
            kusitmsComposableWithAnimation(NavRoutes.SettingNonMember.route) {
                SettingNonMember(
                    navController
                )
            }

            //HomeScreen
            kusitmsComposableWithAnimation(NavRoutes.HomeScreen.route) { HomeScreen(navController) }

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
                    onShowSnackbar = { message ->
                        snackbarHostState.showSnackbar(
                            message = message
                        )
                    },
                    onBack = {
                        navController.navigateUp()
                    },
                    imageViewerViewModel = imageViewerViewModel,
                    onClickImage = {
                        navController.navigate(NavRoutes.ImageViewer.route)
                    }
                )
            }

            // ProfileScreen

            kusitmsComposableWithAnimation(NavRoutes.Profile.route) {
                ProfileScreen(navController = navController)
            }

            kusitmsComposableWithAnimation(NavRoutes.ProfileSearch.route) {
                ProfileSearchScreen(
                    onBackClick = {
                        navController.navigateUp()
                    },
                )
            }


            kusitmsComposableWithAnimation(NavRoutes.ProfileDetail.route) {
                ProfileDetailScreen(
                    onProfileClick = {
                        navController.navigate(NavRoutes.ProfileDetail.createRoute(it.profileId))
                    },
                    onBack = {
                        navController.navigateUp()
                    }
                )
            }

            kusitmsComposableWithAnimation(NavRoutes.ImageViewer.route) {

                ImageViewerScreen(
                    viewModel = imageViewerViewModel,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }

}

@Composable
inline fun <reified T : ViewModel> getViewModel(): T {
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
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
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

