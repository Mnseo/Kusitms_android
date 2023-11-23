package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.PartCategory
import com.kusitms.presentation.model.signIn.SignInViewModel

@Composable
fun partSelectItem(category: PartCategory, onClick: (PartCategory) -> Unit, viewModel:SignInViewModel) {
    val isSelected = viewModel.selectedPart.collectAsState().value?.contains(category.name) == true
    val background = if (isSelected) KusitmsColorPalette.current.Grey500 else Color.Transparent
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(color = background, shape = RoundedCornerShape(size=12.dp))
        .clickable { onClick(category) }
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
