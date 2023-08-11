package com.kusitms.presentation.ui.splash

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.navigation.NavRoutes

@Composable
fun Splash(navController: NavHostController) {
    // NavHostController TestCode
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Splash Screen", textAlign = TextAlign.Center, fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TestNavButton(route = NavRoutes.Login.route, navController = navController)
                TestNavButton(route = NavRoutes.Onboarding.route, navController = navController)
                TestNavButton(route = NavRoutes.Home.route, navController = navController)
                TestNavButton(route = NavRoutes.Setting.route, navController = navController)
            }
        }
    }
}

@Composable
fun TestNavButton(route: String, navController: NavHostController, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            navController.navigate(route) {
                popUpTo(route) {
                    inclusive = true
                }
            }
        },
        modifier = modifier.wrapContentSize(),
    ) {
        Text(
            text = "Go to ${route}"
        )
    }
}

@Preview
@Composable
fun SplashScreen() {
    Splash(navController = rememberNavController())
}