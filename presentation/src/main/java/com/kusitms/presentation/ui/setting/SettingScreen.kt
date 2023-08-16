package com.kusitms.presentation.ui.setting


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.splash.TestNavButton

@Composable
fun Setting(navController: NavHostController) {
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
                text = "Setting Screen", textAlign = TextAlign.Center, fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TestNavButton(route = NavRoutes.Login.route, navController = navController)
                TestNavButton(route = NavRoutes.Home.route, navController = navController)
            }
        }
    }
}

@Preview
@Composable
fun SettingPreview() {
    Setting(navController = rememberNavController())
}