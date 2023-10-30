package com.kusitms.presentation.common.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.kusitms.presentation.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.underArrow

@Composable
fun KusitmsSnackField(
    @StringRes text:Int,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(
            color = KusitmsColorPalette.current.Grey700,
            shape = RoundedCornerShape(16.dp)
        ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = text),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey400
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_under_errow),
                contentDescription = null,
                tint = KusitmsColorPalette.current.Grey300
            )
        }
    }

}