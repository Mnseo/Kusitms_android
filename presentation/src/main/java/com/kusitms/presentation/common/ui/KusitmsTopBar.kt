package com.kusitms.presentation.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.LeftArrow

@Composable
fun KusitsmTopBarTextWithIcon(
    text : String,
    iconContent : @Composable RowScope.() -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = text,
            style = KusitmsTypo.current.SubTitle1_Semibold,
            color =  KusitmsColorPalette.current.Grey100,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.weight(1f))

        iconContent()

    }
}


@Composable
fun KusitsmTopBarBackTextWithIcon(
    text: String,
    onBackClick: () -> Unit,
    iconContent: @Composable RowScope.() -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onBackClick()
                },
            imageVector = LeftArrow.vector,
            contentDescription = "뒤로"
        )
        KusitmsMarginHorizontalSpacer(size = 12)
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = text,
            style = KusitmsTypo.current.SubTitle1_Semibold,
            color =  KusitmsColorPalette.current.Grey100,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        KusitmsMarginHorizontalSpacer(size = 12)
        iconContent()

    }
}