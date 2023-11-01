package com.kusitms.presentation.ui.login.nonMember

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun NonMemberPage() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
        .background(color = KusitmsColorPalette.current.Main500, shape = RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalAlignment = Alignment.Start,
        ) {

        }

    }

}

@Composable
fun NonOfficialPageRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text= stringResource(id = R.string.nonMember_subtitle),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey300,
            modifier = Modifier.padding(vertical = 2.dp)
        )


    }
}