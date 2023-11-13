package com.kusitms.presentation.ui.login

import LoginLogoIv
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradient
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.R
import com.kusitms.presentation.ui.ImageVector.LoginTalkBall

@Composable
fun LoginScreen(
    navController: NavHostController,
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Grey900),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
            {
                Spacer(modifier = Modifier.weight(1f))
                LoginLogo()
                Spacer(modifier = Modifier.weight(1f))
                ButtonColumn(navController)
        }
        
}

@Composable
fun LoginLogo() {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey900
                )
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text= stringResource(id = R.string.login_top_tv),style= KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey300)
            Spacer(modifier = Modifier.height(6.dp))
            LoginLogoIv.DrawLogo()
        }

}

@Composable
fun ButtonColumn(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(255.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = {
                      navController.navigate(NavRoutes.LoginMemberScreen.route)
            },
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey100),
            shape = RoundedCornerShape(size = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.login_btn1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey600)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey100),
            shape = RoundedCornerShape(size = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.login_btn2), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey600)
        }
        Spacer(modifier = Modifier.height(20.dp))
        loginBottomColumn(navController)
    }
}

@Composable
fun loginBottomColumn(navController: NavController) {
    Column(
        modifier = Modifier
            .width(253.dp)
            .padding(horizontal = 0.dp)
            .height(90.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        LoginTalkBall.DrawLoginTalk()
        loginBottomRow(navController)
    }
}


@Composable
fun loginBottomRow(navController: NavController) {
    Row(
        modifier = Modifier
            .width(253.dp)
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        loginClickText1(navController)
        Spacer(modifier = Modifier.weight(1f))
        Icon(painter = painterResource(id = R.drawable.ic_login_row_spacer), contentDescription = null, tint = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.weight(1f))
        loginClickText2(navController)
    }
}

@Composable
fun loginClickText1(navController: NavController) {
    Text(
        modifier = Modifier
            .clickable {
                navController.navigate(NavRoutes.SignInScreen.route)
            },
        text = stringResource(id = R.string.login_row_tv1),
        style = KusitmsTypo.current.Text_Semibold,
        color = KusitmsColorPalette.current.Grey400
    )
}

@Composable
fun loginClickText2(navController: NavController) {
    Text(
        modifier = Modifier
            .clickable {
                navController.navigate(NavRoutes.OpenScreen.route)
            },
        text = stringResource(id = R.string.login_row_tv2),
        style = KusitmsTypo.current.Text_Semibold,
        color = KusitmsColorPalette.current.Grey400
    )
}



@Preview
@Composable
fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}