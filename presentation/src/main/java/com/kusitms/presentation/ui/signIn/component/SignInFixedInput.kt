package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel


@Composable
fun SignInFixedInput(
    modelValue:String
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(
            color = KusitmsColorPalette.current.Grey500,
            shape = RoundedCornerShape(16.dp)
        ), contentAlignment = Alignment.CenterStart) {
        Text(
            text = modelValue,
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Grey400,
            modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 16.dp)
        )
    }
}

