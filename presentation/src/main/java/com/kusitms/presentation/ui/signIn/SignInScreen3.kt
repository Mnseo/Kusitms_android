package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette

@Composable
fun SignInScreen3(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {
        Spacer(modifier = Modifier.height(122.5.dp))
        rocket()
        
        Text(text = )
        
    }
}

@Composable
fun rocket() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components { 
            add(SvgDecoder.Factory())
        }
        .build()
    
    Image(
        painter = rememberAsyncImagePainter(R.drawable.kusitms_non_member_1, imageLoader),
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
    )
}