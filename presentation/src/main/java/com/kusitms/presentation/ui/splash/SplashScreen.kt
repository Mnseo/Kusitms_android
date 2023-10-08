package com.kusitms.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.kusitms.presentation.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Preview
@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        splashLogo()
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = stringResource(id = R.string.splash_tv), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.White)
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

