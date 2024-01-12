package com.kusitms.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun KusitmsBottomNavigationBar(
    content : @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .shadow(
                elevation = 24.dp,
                spotColor = Color(0x330A0A0A),
                ambientColor = Color(0x330A0A0A)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF20232D),
                shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
            )
            .fillMaxWidth()
            .height(76.dp)
            .background(
                color = Color(0xFF0F1011),
                shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
            )
            .padding(start = 12.5.dp, top = 8.dp, end = 12.5.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF0F1011))
        ) {
            content()
        }
    }
}

@Composable
fun RowScope.KusitmsBottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    label : String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .weight(1f)
            .selectable(
                selected = selected,
                onClick = onClick
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(selected) selectedIcon() else icon()
        KusitmsMarginVerticalSpacer(size = 2)
        Text(
            text = label,
            style = KusitmsTypo.current.Caption2,
            color = if(selected) KusitmsColorPalette.current.Grey100 else KusitmsColorPalette.current.Grey400
        )
    }
}