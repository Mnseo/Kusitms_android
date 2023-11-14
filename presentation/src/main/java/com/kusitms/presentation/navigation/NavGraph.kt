package com.kusitms.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.ui.login.LoginScreen
import com.kusitms.presentation.ui.login.member.SignInScreen
import com.kusitms.presentation.ui.signIn.SignInScreen2
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import com.kusitms.presentation.ui.login.findPw.FindPwScreen1
import com.kusitms.presentation.ui.login.member.LoginMemberScreen
import com.kusitms.presentation.ui.signIn.SignInScreen3
import com.kusitms.presentation.ui.splash.SplashScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route
    ) {
        kusitmsComposableWithAnimation(NavRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }

        //SignInScreen
        kusitmsComposableWithAnimation(NavRoutes.SignInScreen.route) { SignInScreen(navController, SignInViewModel()) }
        kusitmsComposableWithAnimation(NavRoutes.SignInScreen2.route) { SignInScreen2(navController) }
        kusitmsComposableWithAnimation(NavRoutes.SignInScreen3.route) { SignInScreen3(navController) }

        //LoginScreen
        kusitmsComposableWithAnimation(NavRoutes.LoginMemberScreen.route) { LoginMemberScreen(navController) }
        kusitmsComposableWithAnimation(NavRoutes.LogInScreen.route) { LoginScreen(navController) }

        //FindPwScreen
        kusitmsComposableWithAnimation(NavRoutes.FindPwScreen1.route) { FindPwScreen1(navController)}

    }
}

//NavGraph Builder Function
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
