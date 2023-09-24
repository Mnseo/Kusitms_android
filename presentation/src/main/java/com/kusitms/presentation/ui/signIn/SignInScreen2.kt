package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.StudyIcon

@Composable
fun SignInScreen2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {
        TitleColumn()
        Spacer(modifier = Modifier.height(32.dp))
        PhotoBox()

    }

}

@Composable
fun PhotoBox() {
    Box(
        modifier = Modifier
            .width(96.dp)
            .height(96.dp)
            .background(color = Color(0xFF20232D), shape = RoundedCornerShape(size = 12.dp))
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImagePhoto()
        }
    }
}

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
            .width(44.dp)
            .height(44.dp)

    )
}

@Composable
fun TitleColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(KusitmsColorPalette.current.Black)
            .height(109.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            StudyIcon.drawStudyIcon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
            TextColumn()
        }

    }
}

@Composable
fun TextColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Black)
            .height(109.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Text(text = stringResource(id = R.string.signin2_text1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        Text(text = stringResource(id = R.string.signin2_text2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Sub1)

    }
}

@Composable
fun introColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Black)
            .height(186.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,

    ) {
        Text(text = stringResource(id = R.string.signin2_text1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        Text(text = stringResource(id = R.string.signin2_text2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Sub1)

    }
}

