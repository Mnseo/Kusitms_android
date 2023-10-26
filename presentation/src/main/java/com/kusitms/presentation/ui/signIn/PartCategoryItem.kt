package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.LikeCategory

@Composable
fun partSelectItem(category: LikeCategory) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        category.icon?.let { iconRes->
            Icon(painter =  painterResource(id = iconRes), contentDescription = null, tint = Color.Unspecified)
        }
        Text(text = category.name, style = KusitmsTypo.current.Text_Medium, color = KusitmsColorPalette.current.Grey100)
    }
}