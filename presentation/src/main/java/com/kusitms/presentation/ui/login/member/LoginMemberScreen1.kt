package com.kusitms.presentation.ui.login.member

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KustimsTypo
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.StudyIcon
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
            .padding(24.dp)
            .background(KusitmsColorPalette.current.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        TitleColumn()
    }

}

@Composable
fun TitleColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Black)
            .height(109.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            StudyIcon._vector?.let {
                Image(
                    imageVector = StudyIcon._vector!!,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
            }
            TextColumn()
        }
        
    }
}

@Composable
fun TextColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Black)
            .height(109.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Text(text = stringResource(id = R.string.text_column_1), style = KustimsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        Text(text = stringResource(id = R.string.text_column_2), style = KustimsTypo.current.Caption1, color = KusitmsColorPalette.current.Sub2)

    }
}






@Preview
@Composable
fun LoginPreview() {
    LoginMember1(navController = rememberNavController())
}