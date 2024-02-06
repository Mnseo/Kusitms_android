package com.kusitms.presentation.ui.home.attend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.home.AttendCurrentModel
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.home.attend.AttendViewModel


@Composable
fun CurriItem(
    model: AttendCurrentModel
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .background(color = KusitmsColorPalette.current.Grey800)
        .height(78.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CurriTitleRow(model = model)
        CurriBadge(model = model)
    }
    KusitmsMarginVerticalSpacer(size = 24)
}

@Composable
fun CurriBadge(
    model: AttendCurrentModel
) {
    val status = AttendViewModel.Status.fromString(model.status) ?: AttendViewModel.Status.PRESENT
    val statusColor = when(status) {
        AttendViewModel.Status.PRESENT -> KusitmsColorPalette.current.Sub1
        AttendViewModel.Status.ABSENT, AttendViewModel.Status.LATE -> KusitmsColorPalette.current.Sub2
        else -> KusitmsColorPalette.current.Grey600
    }
    Column(
        modifier = Modifier
            .width(92.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically)
    ) {
        Box(modifier = Modifier
            .width(52.dp)
            .wrapContentHeight()
            .background(
                color = KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(40.dp)
            )
        ) {
            Text(text = model.status,
                style = KusitmsTypo.current.Text_Semibold,
                color = statusColor,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 4.dp)
            )
        }
        Text(text = model.time,
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400,
        )
    }
}

@Composable
fun CurriTitleRow(
    model: AttendCurrentModel
) {
    val status = AttendViewModel.Status.fromString(model.status) ?: AttendViewModel.Status.PRESENT

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = status.toDrawable()),
            contentDescription = "Status",
            tint = Color.Unspecified
        )
        KusitmsMarginHorizontalSpacer(size = 24)
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
        ) {
            Text(text = model.curriculum,
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey100,
            )
            Text(text = model.date,
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400,
            )
        }
    }
}

@Preview
@Composable
fun priviewModel() {
    CurriItem(model = dummyData)
}

val dummyData = AttendCurrentModel(
    57, "파트 크로스 스터디", "1월 24일", "오후 8:40", "출석"
)