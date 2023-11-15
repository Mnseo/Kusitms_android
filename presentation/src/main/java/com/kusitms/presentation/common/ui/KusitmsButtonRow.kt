package com.kusitms.presentation.common.ui

import android.util.Log
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun ButtonRow(
    text1:String,
    text2:String,
    navController: NavController,
    color1: Color,
    color2: Color,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = color1),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text1, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            onClick = {
                onNextClick()
                Log.d("Click", "go to SignIn")
                      },
            colors = ButtonDefaults.buttonColors(containerColor = color2),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text2, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}

