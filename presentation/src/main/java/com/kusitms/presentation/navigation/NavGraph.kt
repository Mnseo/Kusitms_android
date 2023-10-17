package com.kusitms.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
        startDestination = NavRoutes.SplashScreen.route)
    {
        composable(NavRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(NavRoutes.OpenScreen.route) {
        }

        composable(NavRoutes.SignInScreen.route) {
            val alphaValue = if (currentRoute == NavRoutes.SignInScreen.route) 0.5f else 1.0f
            SignInScreen(navController, alphaValue)
        }

        composable(NavRoutes.LogInScreen.route) {
            LoginScreen(navController)
        }

    }

}