package com.kusitms.presentation.common.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun KusitsmTopBarTextWithIcon(
    text : String,
    iconContent : @Composable () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = text,
            style = KusitmsTypo.current.SubTitle1_Semibold,
            color =  KusitmsColorPalette.current.Grey100
        )
        Spacer(modifier = Modifier.weight(1f))

        iconContent()

    }
}