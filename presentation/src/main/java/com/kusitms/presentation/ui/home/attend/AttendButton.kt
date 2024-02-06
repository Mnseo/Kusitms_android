package com.kusitms.presentation.ui.home.attend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.NavRoutes

@Composable
fun AttendBtnOn(navController: NavHostController) {
    Button(
        modifier = Modifier
            .wrapContentWidth()
            .height(64.dp) ,
        colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Main600) ,
        shape = RoundedCornerShape(size = 12.dp),
        onClick = { navController.navigate(NavRoutes.CameraPreview.route) }
    ) {
        Text(text = stringResource(R.string.attend_btn_attend), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.White, maxLines = 1)
    }
}

@Preview
@Composable
fun AttendBtnOff() {
    Button(
        modifier = Modifier
            .wrapContentWidth()
            .height(64.dp) ,
        colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey500) ,
        shape = RoundedCornerShape(size = 12.dp),
        onClick = { },
        enabled = false
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.attend_btn_attend_wait), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey400)
            Text(text = stringResource(R.string.attend_btn_attend_wait), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey400)
        }
    }
}

@Composable
fun AttendBtnFailure() {
    Button(
        modifier = Modifier
            .wrapContentWidth()
            .height(64.dp) ,
        colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey600) ,
        shape = RoundedCornerShape(size = 12.dp),
        onClick = {},
        enabled = false
    ) {
        Text(text = stringResource(R.string.attend_btn_attend_failure), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Sub2, maxLines = 1)
    }
}

@Composable
fun AttendBtnSuccess() {
    Button(
        modifier = Modifier
            .wrapContentWidth()
            .height(64.dp) ,
        colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey600) ,
        shape = RoundedCornerShape(size = 12.dp),
        onClick = {},
        enabled = false
    ) {
        Text(text = stringResource(R.string.attend_btn_attend_success), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Sub1, maxLines = 1)
    }
}