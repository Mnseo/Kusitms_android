package com.kusitms.presentation.ui.splash

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.KusitmsScreens
import com.kusitms.presentation.navigation.NavRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(NavRoutes.LoginScreen.route)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .background(color = KusitmsColorPalette.current.Grey900)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(1f))
        splashLogo()
        Spacer(modifier = Modifier.weight(1f))
        Text(text = stringResource(id = R.string.splash_tv), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.White)
        Spacer(modifier = Modifier.height(52.dp))
    }


}

@Composable
fun splashLogo() {
    Row (
        modifier = Modifier
            .width(225.dp)
            .background(color = KusitmsColorPalette.current.Grey900)
            .height(63.dp)
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start)
    ) {
        Image(painter = painterResource(id = R.drawable.ic_splash_kusitms), contentDescription = null)
        Image(painter = painterResource(id = R.drawable.ic_splash_plus), contentDescription = null)
    }
}

