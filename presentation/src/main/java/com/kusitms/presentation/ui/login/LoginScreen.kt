package com.kusitms.presentation.ui.login

import LoginLogoIv
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.NavRoutes

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

                Spacer(modifier = Modifier.height(180.dp))

                Text(text = "비전을 가지고 함께 성장하는 학회", style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey300)
                
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

                Text(text = "비회원이신가요? 큐시즘 둘러보기", style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey300)

        }
        
}

//학회원으로 로그인 버튼
@Composable 
fun LoginButton1(text: String, navController: NavHostController, route: String) {
    Button(
        modifier = Modifier
            .width(335.dp)
            .height(56.dp)
            .background(color = Color(0xFF266DFC), shape = RoundedCornerShape(size = 16.dp))
            .padding(top = 16.dp, bottom = 16.dp),

        //Click 시 이벤트 - SignIn 으로 이동
        onClick = {
                  navController.navigate(route) {
                      popUpTo(route) {
                          inclusive = true
                      }
                  }
        },
    ) {
        Text(
            style = KusitmsTypo.current.SubTitle2_Semibold,
            text = text,
            color = KusitmsColorPalette.current.Grey200
        )
    }
}

//관리자로 로그인 버튼
@Composable
fun LoginButton(borderColor: Color, ButtonColor: Color, text: String, route:String, navController: NavHostController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .background(color = ButtonColor, shape = RoundedCornerShape(16.dp)),
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
fun LoginPreview() {
    Login(navController = rememberNavController())
}