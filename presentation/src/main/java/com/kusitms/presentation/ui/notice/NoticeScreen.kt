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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.presentation.common.ui.KusitmsTabItem
import com.kusitms.presentation.common.ui.KusitmsTabRow
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette

enum class NoticeTab(val title : String){
    NOTICE("공지사항"), CURRICULUM("커리큘럼")
}

@Composable
fun NoticeScreen(
    viewModel: NoticeViewModel = hiltViewModel(),
    onNoticeClick : (NoticeModel) -> Unit
){
    var selectedTab by remember { mutableStateOf(NoticeTab.NOTICE) }
    val noticeList by viewModel.noticeList.collectAsStateWithLifecycle()
    val visibleOnlyUnreadNotice by viewModel.visibleOnlyUnreadNotice.collectAsStateWithLifecycle()

    val curriculumList by viewModel.curriculumList.collectAsStateWithLifecycle()

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
                            /* SettingMember 연결 해주심 됩니당 아이콘은 imageVector > trailingicon에 있어용 */
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
                NoticeListScreen(
                    noticeList= noticeList,
                    visibleOnlyUnreadNotice = visibleOnlyUnreadNotice,
                    onClickUnreadNoticeFilter = {
                        viewModel.updateVisibleOnlyUnreadNotice(it)
                    },
                    onNoticeClick = onNoticeClick
                )
            }
            NoticeTab.CURRICULUM-> {
                CurriculumListScreen(
                    curriculumList = curriculumList
                )
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