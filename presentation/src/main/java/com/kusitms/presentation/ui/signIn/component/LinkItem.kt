package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.LinkCategory
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import com.kusitms.presentation.ui.signIn.LinkCheckBox


@Composable
fun LinkItem(category: LinkCategory, onClick: (LinkCategory) -> Unit) {
    var isSelected by remember { mutableStateOf(false) }
    val background = if (isSelected) KusitmsColorPalette.current.Grey500 else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = background, shape = RoundedCornerShape(size = 12.dp))
            .clickable {
                isSelected = !isSelected
                onClick(category)
            }
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        category.linkType.iconRes?.let { painterResource(id = it) }?.let {
            Icon(
                painter = it,
                contentDescription = category.linkType.displayName,
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = category.linkType.displayName,
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Grey100
        )
    }
}
