package com.kusitms.presentation.ui.login.findPw.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.ui.ImageVector.xIcon
import kotlinx.coroutines.delay

@Composable
fun FindPwEmailComval(
    @StringRes text:Int,
    viewModel: FindPwViewModel
) {
    val email by viewModel.email.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(83.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text= stringResource(text),
            color= KusitmsColorPalette.current.Grey400,
            style = KusitmsTypo.current.Caption1,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey500,
                    shape = RoundedCornerShape(size = 16.dp)
                )
        ) {
            Text(
                text= email,
                color= KusitmsColorPalette.current.White,
                style = KusitmsTypo.current.Text_Medium,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
            )
        }
    }

}


