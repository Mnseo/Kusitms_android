package com.kusitms.presentation.ui.signIn

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun SignInFixedInput(
    @StringRes id:Int
) {
    Text(
        text = stringResource(id = id),
        style = KusitmsTypo.current.Text_Medium,
        color = KusitmsColorPalette.current.Grey400,
        modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 16.dp)
    )
    
}