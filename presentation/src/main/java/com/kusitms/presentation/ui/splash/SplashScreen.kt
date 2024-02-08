package com.kusitms.presentation.ui.splash

import android.os.Build.VERSION.SDK_INT
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
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
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitmsSnackBar
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SplashViewModel
import com.kusitms.presentation.model.signIn.TokenStatus
import com.kusitms.presentation.navigation.NavRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel, navController: NavController) {
    val tokenStatus by viewModel.tokenStatus.collectAsState()
    val snackbarHostState = remember { viewModel.snackbarHostState }
    val isLogin by viewModel.isLogin.collectAsState()

    val snackbarMessage = when (tokenStatus) {
        TokenStatus.INVALID -> "토큰 상태가 유효하지 않습니다"
        TokenStatus.SERVER -> "네트워크 연결이 끊어졌습니다" else -> ""
    }

    LaunchedEffect(tokenStatus) {
        viewModel.verifyToken()
        when (tokenStatus) {
            TokenStatus.VALID -> {
                delay(2000)
                navController.navigate(NavRoutes.HomeScreen.route) {
                    popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
                }
            }
            TokenStatus.DEFAULT, TokenStatus.INVALID, TokenStatus.SERVER -> {
                viewModel.showInvalidTokenMessage()
                delay(2000)
                navController.navigate(NavRoutes.LogInScreen.route) {
                    popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
                }
            }
            else -> Unit
        }
    }
    LaunchedEffect(isLogin) {
        when (isLogin) {
            isLogin -> {

            }
            !isLogin -> {
                delay(2000)
                navController.navigate(NavRoutes.LogInScreen.route) {
                    popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
                }
            }
            else -> Unit
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(
            hostState = snackbarHostState,
            snackbar = {snackbarData: SnackbarData ->
                Box(modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 20.dp)
                    .background(
                        color = KusitmsColorPalette.current.Grey600,
                        shape = RoundedCornerShape(12.dp)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text= snackbarMessage, color = KusitmsColorPalette.current.Grey200, style= KusitmsTypo.current.Text_Semibold)
                    }
                }
                KusitmsMarginVerticalSpacer(size = 40)
            }
        ) }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Splash()
        }
    }

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

