package com.kusitms.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kusitms.presentation.ui.login.member.SignInMember1
import com.kusitms.presentation.ui.splash.Splash

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutes.Splash.route,
) {
    androidx.navigation.compose.NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavRoutes.SignIn.route) {
            SignInMember1(navController)
        }
        composable(NavRoutes.Splash.route) {
            Splash(navController)
        }

    }

}