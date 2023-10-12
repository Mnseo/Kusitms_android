package com.kusitms.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.ui.login.LoginScreen
import com.kusitms.presentation.ui.splash.SplashScreen


@Composable
fun KusitmsNavigation() {
    val navController = rememberNavController()
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
        }

        composable(NavRoutes.LogInScreen.route) {
            LoginScreen(navController)
        }

    }

}