package com.kusitms.presentation.ui.notice.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.notice.CommentUiModel
import com.kusitms.presentation.model.notice.NoticeUiModel
import com.kusitms.presentation.model.notice.dummyCommentList
import com.kusitms.presentation.model.notice.noticeDummy
import com.kusitms.presentation.ui.notice.detail.comment.CommentInput
import com.kusitms.presentation.ui.notice.detail.comment.NoticeComment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NoticeDetailScreen(

) {
    val dummyNotice = noticeDummy.firstOrNull() ?: return
    var commentList by remember { mutableStateOf<List<CommentUiModel>>(dummyCommentList) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().background(KusitmsColorPalette.current.Grey800)
    ) {
        KusitsmTopBarTextWithIcon(
            text = dummyNotice.title
        ) {

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(top = 20.dp),
            state = listState
        ){
            item {
                NoticeDetailTitleCard(
                    dummyNotice
                )
            }
            item {
                KusitmsMarginVerticalSpacer(size = 32)
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = dummyNotice.content,
                    style = KusitmsTypo.current.Body2,
                    color =  KusitmsColorPalette.current.Grey300
                )
            }

            item {
                KusitmsMarginVerticalSpacer(size = 32)
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentPadding = PaddingValues(start = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ){
                    item { NoticeDetailImageCard() }
                }
                KusitmsMarginVerticalSpacer(size = 8)
                Text(
                    modifier = Modifier.padding(start = 28.dp),
                    text = "1/10",
                    style = KusitmsTypo.current.Caption2,
                    color =  KusitmsColorPalette.current.Grey500
                )
                KusitmsMarginVerticalSpacer(size = 24)
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    color = KusitmsColorPalette.current.Grey600
                )
            }

            itemsIndexed(
                commentList
            ){ index, comment ->
                if(index == 0){
                    KusitmsMarginVerticalSpacer(size = 20)
                }
                NoticeComment(comment = comment,isLast = index == commentList.lastIndex)
                if(index == commentList.lastIndex && index != 0){
                    KusitmsMarginVerticalSpacer(size = 20)
                }
            }
        }
        CommentInput(
            onClickSend = {
                // 테스트용
                commentList = commentList + commentList.first().copy(
                    content = it,
                    writer = "이채연",
                    commentCount = 0
                )
                coroutineScope.launch {
                    delay(50)
                    listState.animateScrollToItem(commentList.lastIndex + 1)
                }
            }
        )

    }
}

@Composable
fun NoticeDetailTitleCard(
    notice: NoticeUiModel
) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey300
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = notice.curriculum,
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Main2_500
                )
                KusitmsMarginHorizontalSpacer(size = 8)
                Text(
                    text = notice.team,
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Grey300
                )
            }
            Text(
                text = notice.title,
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color =  KusitmsColorPalette.current.Grey200
            )
            KusitmsMarginVerticalSpacer(size = 12)
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(
                    modifier = Modifier
                        .size(16.dp)
                        .background(color = KusitmsColorPalette.current.Grey400)
                )
                KusitmsMarginHorizontalSpacer(size = 4)
                Text(
                    modifier = Modifier.weight(1f),
                    text = notice.name,
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Grey400
                )
                Text(
                    text = notice.date,
                    style = KusitmsTypo.current.Caption2,
                    color =  KusitmsColorPalette.current.Grey400
                )
            }
        }

    }
}

@Composable
fun NoticeDetailImageCard() {
    Card(
        modifier = Modifier
            .size(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey300
        )
    ) {
        Spacer(modifier = Modifier.fillMaxSize())
    }
}
