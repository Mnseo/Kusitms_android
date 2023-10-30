package com.kusitms.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.ui.login.LoginScreen
import com.kusitms.presentation.ui.login.member.SignInScreen
import com.kusitms.presentation.ui.splash.SplashScreen




@Composable
fun KusitmsNavigation() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route
    ) {
        composable(NavRoutes.SplashScreen.route ) {
            SplashScreen(navController)
        }

        composable(NavRoutes.OpenScreen.route) {
        }

        composable(
            NavRoutes.SignInScreen.route,
            enterTransition = {
                slideIntoContainer(
                    towards =  AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            SignInScreen(navController, SignInViewModel())
        }

        composable(
            NavRoutes.LogInScreen.route,
            enterTransition = {
                slideIntoContainer(
                    towards =  AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            LoginScreen(navController)
        }

    }

}