package com.kusitms.presentation.ui.ImageVector

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.presentation.R

@Composable
fun ImagePhoto() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(R.drawable.screen2_photo, imageLoader),
        contentDescription = null,
        modifier = Modifier
            .padding(0.83333.dp)
            .width(44.dp)
            .height(44.dp)
    )
}

@Composable
fun plusIcon() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(R.drawable.ic_plus, imageLoader),
        contentDescription = null,
        contentScale = ContentScale.None,
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
    )
}

