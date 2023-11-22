package com.kusitms.presentation.common.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun <T> KusitmsTabRow(
    modifier: Modifier = Modifier,
    tabItemList : List<T>,
    tabContent : @Composable (T) -> Unit,
){
    Row(
        modifier = modifier.padding(horizontal = 20.dp)
    ){
        tabItemList.forEachIndexed { index, item ->
            tabContent(item)
            if(index != tabItemList.lastIndex)
                Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun KusitmsTabItem(
    text : String,
    isSelected : Boolean,
    onSelect : () -> Unit
){
    Box(
        modifier = Modifier
            .height(48.dp)
            .width(IntrinsicSize.Max)
            .clickable {
                onSelect()
            }

    ){
        Text(
            modifier = Modifier.align(Alignment.Center).padding(horizontal = 12.dp),
            text = text,
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color =  if(isSelected) KusitmsColorPalette.current.Grey100 else KusitmsColorPalette.current.Grey400
        )
        if(isSelected)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .align(Alignment.BottomCenter),
                color = KusitmsColorPalette.current.Grey100
            )

    }
}