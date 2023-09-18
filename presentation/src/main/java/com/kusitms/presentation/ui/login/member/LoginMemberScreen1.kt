package com.kusitms.presentation.ui.login.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KustimsTypo
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.login.Login
import com.kusitms.presentation.ui.login.LoginButton
import com.kusitms.presentation.ui.login.LoginButton1

@Composable
fun LoginMember1(
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

        Spacer(modifier = Modifier.height(180.dp))

        Text(text = "비전을 가지고 함께 성장하는 학회", style = KustimsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey300)

        Spacer(modifier = Modifier.height(6.dp))

        LoginLogoIv.DrawLogo(
            modifier = Modifier
                .height(76.dp)
                .width(257.26.dp))

        Spacer(modifier = Modifier.height(162.dp))

        LoginButton1(
            text = "학회원으로 로그인",
            route = NavRoutes.SignIn.route,
            navController = navController
        )

        Spacer(modifier = Modifier.height(16.dp))

        LoginButton(
            borderColor = KusitmsColorPalette.current.Grey400,
            ButtonColor = KusitmsColorPalette.current.Black,
            text = "관리자로 로그인",
            navController = navController,
            route = NavRoutes.Home.route
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "비회원이신가요? 큐시즘 둘러보기", style = KustimsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey300)

    }

}

@Preview
@Composable
fun LoginPreview() {
    LoginMember1(navController = rememberNavController())
}