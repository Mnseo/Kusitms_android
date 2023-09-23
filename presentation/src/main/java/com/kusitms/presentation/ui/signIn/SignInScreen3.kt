package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.LoginNavRoutes.LoginNonMember.route

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
        middleCard()

        btn(color = KusitmsColorPalette.current.Main500, text = stringResource(id = R.string.signin3_btn), navController = rememberNavController())
    }
}

@Composable
fun middleCard() {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 24.dp,
                spotColor = Color(0x330A0A0A),
                ambientColor = Color(0x330A0A0A)
            )
            .width(290.dp)
            .height(364.dp)
            .background(color = Color(0xFF20232D), shape = RoundedCornerShape(size = 24.dp))
            .padding(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 20.dp)

    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            rocket()
            nameBox(name = "이채연")
        }

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
        painter = rememberAsyncImagePainter(R.drawable.screen3_rocket, imageLoader),
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
    )
}

@Composable
fun nameBox(name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.signin3_text1),
            style = KusitmsTypo.current.Text_Semibold,
            color = KusitmsColorPalette.current.Grey300
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = name,
            style = KusitmsTypo.current.Header1,
            color = KusitmsColorPalette.current.White
        )
        Text(
            text = stringResource(id = R.string.signin3_text2),
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Grey400
        )
    }
}


@Composable
fun btn(color: Color, text: String, navController:NavController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(16.dp)
            )
            .background(color = color, shape = RoundedCornerShape(16.dp)),
        contentPadding = PaddingValues(0.dp),
        onClick = {
            navController.navigate(route) {
                popUpTo(route) {
                    inclusive = true
                }
            }
        }
    ) {
        Text(
            style = KusitmsTypo.current.SubTitle2_Semibold,
            text = text,
            color = KusitmsColorPalette.current.Grey200
        )
    }
}


@Preview
@Composable
fun example() {
    SignInScreen3(navController = rememberNavController())
}