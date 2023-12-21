package com.kusitms.presentation.ui.notice.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.presentation.common.ui.KusitmsDialog
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.MoreVertical
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Setting
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.UserBackground
import com.kusitms.presentation.ui.notice.detail.comment.CommentInput
import com.kusitms.presentation.ui.notice.detail.comment.NoticeComment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoticeDetailScreen(
    viewModel: NoticeDetailViewModel = hiltViewModel(),
    onBack : () -> Unit
) {
    val notice by viewModel.notice.collectAsStateWithLifecycle()
    val commentList by viewModel.commentList.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var openBottomSheet by remember { mutableStateOf<NoticeDetailModalState?>(null) }
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    
    var openDialogState by remember { mutableStateOf(false) }
    
    if(openDialogState){
        KusitmsDialog(
            title = "신고",
            content = {
                Text(
                    text = "타 서비스, 앱, 사이트 등 게시판 외부로 회원을 \n" +
                            "유도하거나 공동구매, 할인 쿠폰, 홍보성 이벤트 등 \n" +
                            "허가되지 않은 광고/홍보 게시물",
                    textAlign = TextAlign.Center,
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Grey400
                )
                KusitmsMarginVerticalSpacer(size = 24)
                Text(
                    text = "모든 신고는 24시간 이내에 확인 후 조치합니다. 신고 사유에 \n" +
                            "맞지 않는 신고를 했을 경우, 해당 신고는 처리되지 않습니다.",
                    textAlign = TextAlign.Center,
                    style = KusitmsTypo.current.Caption2,
                    color =  KusitmsColorPalette.current.Sub2
                )
            },
            okColor = KusitmsColorPalette.current.Sub2,
            okText = "신고하기",
            onOk = {
                //viewModel.reportNoticeComment()
                   },
            onCancel = {
                openDialogState = false
            }) {
            openDialogState = false
        }
    }

    if(openBottomSheet != null){
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = { Box(Modifier.height(0.dp)) },
            onDismissRequest = { openBottomSheet = null },
            sheetState = bottomSheetState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            when(openBottomSheet ?: return@ModalBottomSheet){
                NoticeDetailModalState.More -> {
                    NoticeMoreBottom()
                }
                NoticeDetailModalState.Report -> {
                    NoticeCommentReportBottom(
                        onClick = {
                            openDialogState = true
                            openBottomSheet = null
                        }
                    ) {
                        openBottomSheet = null
                    }
                }
            }


        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey800)
    ) {
        KusitsmTopBarBackTextWithIcon(
            text = notice.title,
            onBackClick = {
                onBack()
            }
        ) {
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        openBottomSheet = NoticeDetailModalState.More
                    },
                imageVector = KusitmsIcons.MoreVertical,
                contentDescription = "더보기"
            )
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
                    notice
                )
            }
            item {
                KusitmsMarginVerticalSpacer(size = 32)
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = notice.content,
                    style = KusitmsTypo.current.Body2,
                    color =  KusitmsColorPalette.current.Grey300
                )
            }

            item {
                KusitmsMarginVerticalSpacer(size = 32)
                if(notice.imageUrl.isNotBlank()){
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentPadding = PaddingValues(start = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ){
                        item { NoticeDetailImageCard(
                            notice.imageUrl
                        ) }
                    }
                    KusitmsMarginVerticalSpacer(size = 8)
                    Text(
                        modifier = Modifier.padding(start = 28.dp),
                        text = "1/1",
                        style = KusitmsTypo.current.Caption2,
                        color =  KusitmsColorPalette.current.Grey500
                    )
                    KusitmsMarginVerticalSpacer(size = 24)
                }

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
                NoticeComment(comment = comment,
                    onClickReport = {
                        openBottomSheet = NoticeDetailModalState.Report
                    },
                    onClickDelete = {
                        viewModel.deleteNoticeComment(
                            comment.commentId
                        )
                    },
                    isLast = index == commentList.lastIndex)
                if(index == commentList.lastIndex && index != 0){
                    KusitmsMarginVerticalSpacer(size = 20)
                }
            }
        }
        CommentInput(
            onClickSend = {
                 viewModel.addNoticeComment(
                     it
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
    notice: NoticeModel
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
                if(notice.profileImage.isEmpty())
                    Image(
                        modifier = Modifier
                            .size(16.dp),
                        imageVector = KusitmsIcons.UserBackground,
                        contentDescription = "유저"
                    )
                else {

                }
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
fun NoticeDetailImageCard(
    imageUrl : String
) {
    Card(
        modifier = Modifier
            .size(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey300
        )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
        )
    }
}

enum class NoticeDetailModalState {
    More, Report
}

@Composable
fun NoticeMoreBottom(
    onClickEdit : () -> Unit = {},
    onClickDelete : () -> Unit = {}
) {
    var isDeleteMode by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .systemBarsPadding()
    ) {
        if(!isDeleteMode){
            ModalTextBox(
                "공지 수정하기",
                onClick = onClickEdit
            )
            ModalTextBox(
                "공지 삭제하기",
                onClick = {
                    isDeleteMode = true
                }
            )
        }else {
            KusitmsMarginVerticalSpacer(size = 16)
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "공지 삭제하기",
                style = KusitmsTypo.current.SubTitle1_Semibold,
                color =  KusitmsColorPalette.current.Grey100
            )
            KusitmsMarginVerticalSpacer(size = 8)
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "해당 공지 글이 삭제됩니다.",
                style = KusitmsTypo.current.Text_Medium,
                color =  KusitmsColorPalette.current.Grey300
            )
            KusitmsMarginVerticalSpacer(size = 40)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)

            ){
                OutlinedButton(
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    onClick = {
                              isDeleteMode = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey600),
                    border = BorderStroke(1.dp, KusitmsColorPalette.current.Grey400),
                    shape = RoundedCornerShape(size = 12.dp)
                ) {
                    Text(text = "취소하기", style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey200)
                }

                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    onClick = {
                        onClickDelete()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey100),
                    shape = RoundedCornerShape(size = 12.dp)
                ) {
                    Text(text = "삭제하기", style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey600)
                }
            }
        }
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun NoticeCommentReportBottom(
    onClick: () -> Unit= {},
    onDismiss : () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .systemBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp)
        ){
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "신고 사유 선택",
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color =  KusitmsColorPalette.current.Grey300
            )
            Spacer(modifier = Modifier
                .height(0.dp)
                .weight(1f))
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onDismiss()
                    },
                imageVector = KusitmsIcons.Close,
                contentDescription = "닫기"
            )
        }
        KusitmsMarginVerticalSpacer(size = 20)
        ModalTextBox(
            text = "상업적 광고 및 판매",
            boxPadding = PaddingValues(horizontal = 12.5.dp),
            onClick = {
                onClick()
            }
        )
        ModalTextBox(
            text = "욕설/비하",
            boxPadding = PaddingValues(horizontal = 12.5.dp),
            onClick = {
                onClick()
            }
        )
        ModalTextBox(
            text = "유출/사칭/사기",
            boxPadding = PaddingValues(horizontal = 12.5.dp),
            onClick = {
                onClick()
            }
        )
        ModalTextBox(
            text = "정당/정치인 비하 및 선거운동",
            boxPadding = PaddingValues(horizontal = 12.5.dp),
            onClick = {
                onClick()
            }
        )
        ModalTextBox(
            text = "낚시/놀람/도배",
            boxPadding = PaddingValues(horizontal = 12.5.dp),
            onClick = {
                onClick()
            }
        )
        ModalTextBox(
            text = "음란물/불건전한 만남 및 대화",
            boxPadding = PaddingValues(horizontal = 12.5.dp),
            onClick = {
                onClick()
            }
        )
        KusitmsMarginVerticalSpacer(size = 24)
    }
}


@Composable
fun ModalTextBox(
    text : String,
    boxPadding : PaddingValues = PaddingValues(horizontal = 20.dp),
    onClick : () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable {
                onClick()
            }
            .padding(boxPadding),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = text,
            style = KusitmsTypo.current.Text_Medium,
            color =  KusitmsColorPalette.current.Grey100
        )
    }
}