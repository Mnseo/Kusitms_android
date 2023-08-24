package com.kusitms.presentation.ui.login

import LoginLogoIv
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTheme
import com.kusitms.presentation.common.ui.theme.KustimsTypo

@Composable
fun Login(
    navController: NavHostController,
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
            {
                Text(text = "비전을 가지고 성장하는 학회", style = KustimsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey300)
                
                Spacer(modifier = Modifier.height(6.dp))

                LoginLogoIv._vector?.let {
                    Image(
                        imageVector = LoginLogoIv._vector!!,
                        contentDescription = null,
                        modifier = Modifier.size(260.dp),
                        contentScale = ContentScale.FillBounds,
                        alignment = Alignment.Center

                    )
                }
                    
        }
        
}

@Preview
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}