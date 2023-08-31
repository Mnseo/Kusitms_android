package com.kusitms.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KustimsTypo
import com.kusitms.presentation.ui.ImageVector.RightArrow
import com.kusitms.presentation.ui.ImageVector.tralingIcon


@Composable
fun topBar(string: String, booleanRight: Boolean) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(start = 20.dp, top = 4.dp, end = 20.dp, bottom = 4.dp)
                .background(color = KusitmsColorPalette.current.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            topBarLeft(string = string)

            if (booleanRight) {
                // 오른쪽에 icon 있다면
                tralingIcon.DrawTraling(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )

            }
            else {
                //오른쪽에 icon 없다면
                Spacer(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }

        }

    }

@Composable
fun topBarLeft(string : String) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .height(48.dp)
            .background(color = KusitmsColorPalette.current.Black),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RightArrow.DrawRightArrow(
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
        )

        Spacer(modifier = Modifier
            .width(12.dp)
        )

        topBarText(string = string)

    }

}

@Composable
fun topBarText(string :String) {
    Text(
        style = KustimsTypo.current.SubTitle2_Semibold,
        color = KusitmsColorPalette.current.Grey100,
        text = string,
    )
}


@Preview(showBackground = true)
@Composable
fun preview() {
    topBar("큐시즘 둘러보기", booleanRight = true)
}