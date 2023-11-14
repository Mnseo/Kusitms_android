package com.kusitms.presentation.ui.login.findPw

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.NavRoutes

@Composable
fun FindPwBtn1(isValid: Boolean, navController:NavHostController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = {
            navController.navigate(NavRoutes.FindPwScreen2.route)
        },
        colors = ButtonDefaults.buttonColors(containerColor = if (isValid) KusitmsColorPalette.current.Main500 else KusitmsColorPalette.current.Grey500)
        ,
        shape = RoundedCornerShape(size = 16.dp)
    ) {
        Text(text = stringResource(id = R.string.find_pw_btn1), style = KusitmsTypo.current.SubTitle2_Semibold, color = if (isValid) KusitmsColorPalette.current.White else KusitmsColorPalette.current.Grey400)
    }
}