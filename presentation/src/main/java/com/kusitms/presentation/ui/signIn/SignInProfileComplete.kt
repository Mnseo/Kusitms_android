package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.domain.usecase.signin.AuthMemberProfileUseCase
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.navigation.NavRoutes.LoginNonMember.route

@Composable
fun SignInProfileComplete(viewModel: SignInViewModel, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(1f))
        SignIn3Card(viewModel)
        Spacer(modifier = Modifier.weight(1f))
        btn(color = KusitmsColorPalette.current.Main500, text = stringResource(id = R.string.signin3_btn), navController = navController)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun SignIn3Card(viewModel: SignInViewModel) {
    val name by viewModel.name.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        middleCard(viewModel)
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = stringResource(id = R.string.signin3_text3) + " ${name}님의", style= KusitmsTypo.current.Body1, color = KusitmsColorPalette.current.Grey200)
        Text(text = stringResource(id = R.string.signin3_text4), style = KusitmsTypo.current.Body1, color = KusitmsColorPalette.current.Grey200)
    }
}

@Composable
fun middleCard(viewModel: SignInViewModel) {
    val name by viewModel.name.collectAsState()
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.screen3_rocket),
                contentDescription = null
            )
            nameBox(name = name)
        }
    }
}


@Composable
fun nameBox(name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.signin3_text1),
            style = KusitmsTypo.current.Text_Semibold,
            color = KusitmsColorPalette.current.Grey300,
            modifier = Modifier.padding(bottom = 15.dp)
        )
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
fun btn(color: Color, text: String, navController: NavHostController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 20.dp, end = 20.dp)
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(16.dp)
            )
            .background(color = color, shape = RoundedCornerShape(16.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = color), // 여기에서 배경색 지정
        contentPadding = PaddingValues(0.dp),
        onClick = {
            navController.navigate(NavRoutes.Notice.route) {
                popUpTo(NavRoutes.SignInProfileComplete.route) { inclusive = true }
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

