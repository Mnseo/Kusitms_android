package com.kusitms.presentation.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kusitms.presentation.navigation.KusitmsScreens
import kotlinx.coroutines.delay

@Composable
fun splashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue =  0.9f,
        animationSpec = tween(
            durationMillis = 800,
            easing = {
                OvershootInterpolator(8f)
                    .getInterpolation(it)
            }
        ))
        delay(2000L)
        navController.navigate(KusitmsScreens.OpenScreen.name)
    })
}