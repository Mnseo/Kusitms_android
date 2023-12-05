package com.kusitms.presentation.ui.notice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitmsTabItem
import com.kusitms.presentation.common.ui.KusitmsTabRow
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.notice.NoticeUiModel

enum class NoticeTab(val title : String){
    NOTICE("공지사항"), CURRICULUM("커리큘럼")
}

@Composable
fun NoticeScreen(
    onNoticeClick : (NoticeUiModel) -> Unit
){
    var selectedTab by remember { mutableStateOf(NoticeTab.NOTICE) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey800)
    ) {
        KusitsmTopBarTextWithIcon(
            text = "공지",
            iconContent = {
                Spacer(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {

                        }
                        .background(Color.White)
                )
            }
        )

        KusitmsTabRow(
            tabItemList = NoticeTab.values().toList(),
        ){
            KusitmsTabItem(
                text = it.title,
                isSelected = selectedTab == it
            ) {
                selectedTab = it
            }
        }
        when(selectedTab){
            NoticeTab.NOTICE-> {
                NoticeList(
                    onNoticeClick = onNoticeClick
                )
            }
            NoticeTab.CURRICULUM-> {
                CurriculumList()
            }
        }
    }
}


@Preview
@Composable
fun NoticeScreenPreview(){
    NoticeScreen(
        onNoticeClick = {}
    )
}