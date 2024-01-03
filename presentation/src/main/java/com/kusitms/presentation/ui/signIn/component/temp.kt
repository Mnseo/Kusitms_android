package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun<T> bottomSheet_check(
    title: String,
    itemList: List<T>,
    openBottomSheet: Boolean = false,
    onChangeOpenBottomSheet: (Boolean) -> Unit = {},
    buttonText: String,
    buttonOnClick: () -> Unit
) {

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if(openBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.LightGray,
            onDismissRequest = { onChangeOpenBottomSheet(false) },
            sheetState = bottomSheetState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(24.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, color = Color.White)
                Spacer(modifier = Modifier.height(30.dp))
                bottomSheet_tab(itemList = itemList)
                androidx.compose.material.Button(onClick = { /*TODO*/ }) {
                    
                }
                Spacer(modifier = Modifier.height(24.dp))
                
            }

        }
    }
}

@Composable
fun<T> bottomSheet_tab(
    itemList: List<T>,
    selectedItem: List<T> = listOf(),
    onItemSelected: (T) -> Unit = {}
) {
    tabRow(
        tabItemList = itemList,
        tabContent = { _list ->
            tabItem(
                text = _list.toString(),
                isSelected = _list == selectedItem,
                onSelect = { onItemSelected(_list) }
            )
        })
}

@Composable
fun <T> tabRow(
    modifier: Modifier = Modifier,
    tabItemList : List<T> = listOf(),
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
fun tabItem(
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
        androidx.compose.material3.Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 12.dp),
            text = text,
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = if (isSelected) KusitmsColorPalette.current.Grey100 else KusitmsColorPalette.current.Grey400
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
