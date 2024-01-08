package com.kusitms.presentation.ui.splash

import android.os.Build.VERSION.SDK_INT
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import coil.size.Size.Companion.ORIGINAL
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SplashViewModel
import com.kusitms.presentation.model.signIn.TokenStatus
import com.kusitms.presentation.navigation.NavRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel, navController: NavController) {
    val tokenStatus by viewModel.tokenStatus.collectAsState()

    LaunchedEffect(tokenStatus) {
        viewModel.verifyToken()
        Log.d("tokenStatus", tokenStatus.toString())
        when (tokenStatus) {
            TokenStatus.VALID -> {
                delay(2000)
                navController.navigate(NavRoutes.LogInScreen.route) {
                    popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
                }
            }
            TokenStatus.DEFAULT, TokenStatus.INVALID -> {
                delay(2000)
                navController.navigate(NavRoutes.LogInScreen.route) {
                    popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
                }
            }
            else -> Unit
        }
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
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(coil.decode.GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.ic_splash_gif).apply(block = {
                size(ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = Modifier
            .width(335.dp)
            .height(335.dp),
    )
}

