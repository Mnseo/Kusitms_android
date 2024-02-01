package com.kusitms.presentation.ui.home.attend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Preview
@Composable
fun AttendScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey900)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        KusitmsMarginVerticalSpacer(size = 8)
        AttendPreColumn()
        KusitmsMarginVerticalSpacer(size = 24)
        AttendRecordColumn()

    }
}

@Composable
fun AttendPreColumn() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(108.dp)
        .background(color = KusitmsColorPalette.current.Grey800, shape = RoundedCornerShape(24.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .width(188.dp)
                    .height(56.dp)
            ) {
                Text(text = stringResource(R.string.attend_box1_title), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Main500)
                Text(text = stringResource(R.string.attend_box1_subTitle), style = KusitmsTypo.current.SubTitle1_Semibold, color = KusitmsColorPalette.current.White)
            }
            Button(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(64.dp) ,
                colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Main600) ,
                shape = RoundedCornerShape(size = 12.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(R.string.attend_btn_attend), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.White, maxLines = 1)
            }
        }
    }
}

@Composable
fun AttendRecordColumn() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(266.dp)
        .background(color = KusitmsColorPalette.current.Grey800, shape = RoundedCornerShape(24.dp))){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.attend_box2_title), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
                Box(modifier = Modifier
                    .width(123.dp)
                    .height(36.dp)
                    .background(
                        color = KusitmsColorPalette.current.Grey600,
                        shape = RoundedCornerShape(8.dp)
                    )
                ){
                    Text(text = stringResource(R.string.attend_btn2_attend), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400, modifier = Modifier.align(Alignment.Center))
                }
            }
            KusitmsMarginVerticalSpacer(size = 24)
            Text(text = stringResource(R.string.attend_box3_title), style = KusitmsTypo.current.Header2, color = KusitmsColorPalette.current.Grey100)
            KusitmsMarginVerticalSpacer(size = 6)
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(R.string.attend_box3_subTitle_ok), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Sub1)
                KusitmsMarginHorizontalSpacer(size = 6)
                Icon(painter = painterResource(id = R.drawable.ic_thumb), contentDescription = null, tint = Color.Unspecified)
            }
            KusitmsMarginVerticalSpacer(size = 24)

        }
    }
}