package com.kusitms.presentation.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.setting.SettingUiModel
import com.kusitms.presentation.model.setting.SettingViewModel


@Composable
fun SettingToggle(title:String, viewModel:SettingViewModel) {
    val isToggle by viewModel.alarmState.collectAsState()
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = KusitmsColorPalette.current.Grey700)
        .height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = title, style = KusitmsTypo.current.Text_Medium, color= KusitmsColorPalette.current.Grey200)
                ToggleBtn(selected = isToggle) {
                    viewModel.onToggleChange(it)
                }
            }
        }
}

@Composable
fun ToggleBtn(
    selected: Boolean,
    modifier : Modifier = Modifier,
    onUpdate: (Boolean) -> Unit
) {
    Card(
        modifier = modifier
            .width(58.dp)
            .height(28.dp)
            .clickable { onUpdate(!selected) },
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (selected) KusitmsColorPalette.current.Main500
                    else KusitmsColorPalette.current.Main300.copy(0.4f),
                ), contentAlignment = if (selected) Alignment.CenterEnd else Alignment.CenterStart
        ) {
            CheckCircle(modifier = Modifier.padding(5.dp))
        }

    }
}

@Composable
fun CheckCircle(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(Color.White)
    )
}
