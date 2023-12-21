package com.kusitms.presentation.ui.notice

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmScrollToTopButton
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Flag
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.NoticeDark
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Setting
import com.kusitms.presentation.ui.profile.ProfileScreen
import kotlinx.coroutines.launch

@Composable
fun CurriculumListScreen(
    curriculumList : List<CurriculumModel>,
    onNoticeClick : (NoticeModel) -> Unit
){

    val listState = rememberLazyListState()
    val isShownButton by remember { derivedStateOf { listState.firstVisibleItemScrollOffset > 0 } }
    val coroutineScope = rememberCoroutineScope()
    
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Grey900),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = listState
        ){
            item {
                Column(
                    modifier = Modifier.let {
                        if(curriculumList.isEmpty()) it.fillParentMaxSize() else it
                            .fillMaxWidth()
                            .wrapContentHeight()
                    }
                ) {
                    KusitmsMarginVerticalSpacer(size = 16)

                    Row(
                        modifier = Modifier.padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            modifier = Modifier
                                .size(24.dp),
                            imageVector = KusitmsIcons.Flag,
                            contentDescription = "커리큘럼"
                        )
                        KusitmsMarginHorizontalSpacer(size = 10)
                        Text(
                            text = "이번 기수의 전체 커리큘럼이에요",
                            style = KusitmsTypo.current.Text_Semibold,
                            color =  KusitmsColorPalette.current.Grey300
                        )
                    }

                    KusitmsMarginVerticalSpacer(size = 52)

                    if(curriculumList.isEmpty())
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ){
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "아직 커리큘럼이 없어요",
                                color = KusitmsColorPalette.current.Grey400,
                                style = KusitmsTypo.current.Caption1
                            )
                        }
                }

            }
            if(curriculumList.isNotEmpty()){
                itemsIndexed(curriculumList){ index, curriculum ->
                    KusitmsCurriculumItem(
                        curriculum = curriculum,
                        index = index,
                        onNoticeClick = onNoticeClick
                    )
                }
            }

        }

        KusitsmScrollToTopButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 16.dp),
            isVisible = isShownButton
        ) {
            coroutineScope.launch {
                listState.animateScrollToItem(0)
            }
        }
    }

}


@Composable
fun KusitmsCurriculumItem(
    curriculum : CurriculumModel,
    index : Int, // 0번부터 시작하는 리스트의 진짜 인덱스 값,
    onNoticeClick : (NoticeModel) -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(bottom = 40.dp)

    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .height(24.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(KusitmsColorPalette.current.Main500),
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 7.5.dp),
                    text = "${index+1}".padStart(2,'0'),
                    style = KusitmsTypo.current.Caption1,
                    textAlign = TextAlign.Center,
                    color =  KusitmsColorPalette.current.Main100
                )
            }
            KusitmsMarginHorizontalSpacer(size = 12)
            Text(
                text = curriculum.curriculumName,
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color =  KusitmsColorPalette.current.White
            )
        }
        if(curriculum.curriculumNoticeList.isNotEmpty()){
            KusitmsMarginVerticalSpacer(size = 8)
            CurriculumNoticeDropdown(
                title = curriculum.title,
                curriculum.curriculumNoticeList,
                isExpanded = expanded,
                onExpand = {
                    expanded = !expanded
                },
                onNoticeClick = onNoticeClick
            )
        }

    }
}

@Composable
fun CurriculumNoticeDropdown(
    title : String,
    curriculumNoticeList : List<NoticeModel> = emptyList(),
    isExpanded : Boolean,
    onExpand : () -> Unit = {},
    scrollState: ScrollState = rememberScrollState(),
    onNoticeClick : (NoticeModel) -> Unit
) {
    val animatedHeight by animateDpAsState(
        targetValue = if(isExpanded) curriculumNoticeList.getCurriculumNoticeCardHeight().dp else 56.dp
    )

    Card(
        modifier = Modifier
            .height(animatedHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey300
        )
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .clickable {
                    onExpand()
                }
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(4.dp)
                    .size(20.dp)
                    .clickable {

                    },
                imageVector = KusitmsIcons.NoticeDark,
                contentDescription = "커리큘럼"
            )
            KusitmsMarginHorizontalSpacer(size = 4)
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                style = KusitmsTypo.current.Text_Medium,
                color =  KusitmsColorPalette.current.Grey300
            )
            KusitmsMarginHorizontalSpacer(size = 4)
            Icon(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .rotate(if (isExpanded) 180f else 0f)
                    .size(24.dp)
                    .clickable {
                        onExpand()
                    },
                imageVector = KusitmsIcons.ArrowDown,
                contentDescription = null)
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
                    .verticalScroll(scrollState)
            ) {
                curriculumNoticeList.forEachIndexed { index, noticeUiModel ->
                    CurriculumNoticeItem(
                        notice = noticeUiModel,
                        onNoticeClick = onNoticeClick
                    )
                    if(index != curriculumNoticeList.lastIndex)
                        KusitmsMarginVerticalSpacer(size = 4)
                }
            }

        }
    }
}

@Composable
fun CurriculumNoticeItem(
    notice : NoticeModel,
    onNoticeClick : (NoticeModel) -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onNoticeClick(notice)
        }.padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier
                    .weight(1f),
                text = notice.title,
                style = KusitmsTypo.current.Text_Semibold,
                color =  KusitmsColorPalette.current.Grey200,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Box(
                modifier = Modifier
                    .height(34.dp)
                    .wrapContentWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = notice.date,
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Grey500
                )
            }
        }
        KusitmsMarginVerticalSpacer(size = 4)
        Text(
            text = notice.content,
            style = KusitmsTypo.current.Caption1,
            color =  KusitmsColorPalette.current.Grey400,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}


fun List<NoticeModel>.getCurriculumNoticeCardHeight() : Int {
    return when(size){
        0 -> 56
        1 -> 142
        2 -> 232
        3 -> 322
        else -> 424
    }
}
