package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.xIcon

@Composable
fun KusitmsPartSnack() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
            .background(
                color = KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .height(260.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        partSnackTitle()

    }
}

@Composable
fun partSnackTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
            .height(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.part_snack_title), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        xIcon.drawxIcon()

    }
}

@Composable
fun partRow() {

}

@Preview
@Composable
fun ExamplePartSnack() {
    KusitmsPartSnack()
}