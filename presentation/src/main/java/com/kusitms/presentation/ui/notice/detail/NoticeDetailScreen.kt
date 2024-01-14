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
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsDialog
import com.kusitms.presentation.common.ui.KusitmsDialogSingleButton
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.getViewModel
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.MoreVertical
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.UserBackground
import com.kusitms.presentation.ui.notice.detail.comment.CommentInput
import com.kusitms.presentation.ui.notice.detail.comment.NoticeComment
import com.kusitms.presentation.ui.viewer.ImageViewerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel.Companion.NoticeDetailSnackbarEvent as NoticeDetailSnackbarEvent
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel.Companion.NoticeDetailDialogEvent as NoticeDetailDialogEvent

sealed class NoticeDetailDialogState() {
    data class Report(val comment: CommentModel, val report: ReportCategory, val memberId: Int) :
        NoticeDetailDialogState()

    object AlreadyReport : NoticeDetailDialogState()

    data class CommentDelete(val comment: CommentModel) : NoticeDetailDialogState()
}

sealed class NoticeDetailModalState() {
    data class More(val comment: CommentModel) : NoticeDetailModalState()
    data class Report(val comment: CommentModel, val memberId: Int) : NoticeDetailModalState()

    data class Comment(val comment: CommentModel) : NoticeDetailModalState()

}

enum class ReportCategory(val titleId: Int, val contentId: Int) {
    COMMERCIAL(
        R.string.notice_report_title_commercial,
        R.string.notice_report_content_commercial
    ),
    ABUSE(
        R.string.notice_report_title_abuse,
        R.string.notice_report_content_abuse
    ),
    FRAUD(
        R.string.notice_report_title_fraud,
        R.string.notice_report_content_fraud
    ),
    POLITICAL(
        R.string.notice_report_title_political,
        R.string.notice_report_content_political
    ),
    FISHING(
        R.string.notice_report_title_fishing,
        R.string.notice_report_content_fishing
    ),
    PORNOGRAPHY(
        R.string.notice_report_title_pornography,
        R.string.notice_report_content_pornography
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoticeDetailScreen(
    viewModel: NoticeDetailViewModel = hiltViewModel(),
    imageViewerViewModel: ImageViewerViewModel,
    onShowSnackbar : suspend (String) -> Unit,
    onBack: () -> Unit,
    onClickImage: () -> Unit
) {
    val notice by viewModel.notice.collectAsStateWithLifecycle()
    val commentList by viewModel.commentList.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var openBottomSheet by remember { mutableStateOf<NoticeDetailModalState?>(null) }
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var openDialogState by remember { mutableStateOf<NoticeDetailDialogState?>(null) }

    LaunchedEffect(key1 = Unit){
        viewModel.snackbarEvent.collect {
            onShowSnackbar(
                when(it){
                    NoticeDetailSnackbarEvent.ADDED_COMMENT -> "댓글이 추가되었습니다."
                    NoticeDetailSnackbarEvent.DELETED_COMMENT -> "댓글이 삭제되었습니다."
                    NoticeDetailSnackbarEvent.REPORTED_COMMENT -> "댓글 신고가 완료되었습니다."
                    NoticeDetailSnackbarEvent.NETWORK_ERROR -> "네트워크 에러가 발생하였습니다."
                }
            )
        }
    }

    LaunchedEffect(key1 = Unit){
        viewModel.dialogEvent.collect {
            when(it){
                NoticeDetailDialogEvent.ALREADY_REPORTED_COMMENT ->{
                    openDialogState = NoticeDetailDialogState.AlreadyReport
                }
            }
        }
    }

    if (openDialogState != null) {
        when (openDialogState) {
            is NoticeDetailDialogState.Report -> {
                (openDialogState as NoticeDetailDialogState.Report).let { reportState ->
                    val content = stringResource(id = reportState.report.contentId)
                    KusitmsDialog(
                        title = stringResource(id = reportState.report.titleId),
                        content = {
                            Text(
                                text = content,
                                textAlign = TextAlign.Center,
                                style = KusitmsTypo.current.Caption1,
                                color = KusitmsColorPalette.current.Grey400
                            )
                            KusitmsMarginVerticalSpacer(size = 24)
                            Text(
                                text = "모든 신고는 24시간 이내에 확인 후 조치합니다. 신고 사유에 \n" +
                                        "맞지 않는 신고를 했을 경우, 해당 신고는 처리되지 않습니다.",
                                textAlign = TextAlign.Center,
                                style = KusitmsTypo.current.Caption2,
                                color = KusitmsColorPalette.current.Sub2
                            )
                        },
                        okColor = KusitmsColorPalette.current.Sub2,
                        okText = "신고하기",
                        onOk = {
                            viewModel.reportNoticeComment(
                                commentId = reportState.comment.commentId,
                                content = content,
                                memberId = reportState.memberId
                            )
                            openDialogState = null
                        },
                        onCancel = {
                            openDialogState = null
                        }) {
                        openDialogState = null
                    }

                }
            }

            is NoticeDetailDialogState.CommentDelete -> {
                (openDialogState as NoticeDetailDialogState.CommentDelete).let { commentDeleteState ->
                    KusitmsDialog(
                        title = "댓글 삭제",
                        content = {
                            Text(
                                text = "해당 댓글의 답글도 모두 삭제됩니다",
                                textAlign = TextAlign.Center,
                                style = KusitmsTypo.current.Caption1,
                                color = KusitmsColorPalette.current.Grey300
                            )
                        },
                        okColor = KusitmsColorPalette.current.Grey200,
                        okText = "삭제하기",
                        onOk = {
                            viewModel.deleteNoticeComment(
                                commentDeleteState.comment.commentId
                            )
                            openDialogState = null
                        },
                        onCancel = {
                            openDialogState = null
                        }) {
                        openDialogState = null
                    }
                }

            }
            is NoticeDetailDialogState.AlreadyReport -> {
                KusitmsDialogSingleButton(
                    title = "이미 신고한 댓글입니다.",
                    content = {
                        Text(
                            text = "하나의 댓글에 두번 이상 신고는 불가능합니다",
                            textAlign = TextAlign.Center,
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Grey300
                        )
                    },
                    buttonColor = KusitmsColorPalette.current.Grey200,
                    buttonText = "확인",
                    onClickButton = {
                        openDialogState = null
                    }) {
                    openDialogState = null
                }
            }
            else -> {}
        }

    }

    if (openBottomSheet != null) {
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = { Box(Modifier.height(0.dp)) },
            onDismissRequest = { openBottomSheet = null },
            sheetState = bottomSheetState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            when (openBottomSheet ?: return@ModalBottomSheet) {
                is NoticeDetailModalState.Comment -> {
                    NoticeCommentBottom(
                        (openBottomSheet as NoticeDetailModalState.Comment).comment,
                        emptyList()
                    )
                }

                is NoticeDetailModalState.More -> {
                    NoticeMoreBottom()
                }

                is NoticeDetailModalState.Report -> {
                    NoticeCommentReportBottom(
                        onClick = {
                            (openBottomSheet as NoticeDetailModalState.Report).let { reportState ->
                                openDialogState = NoticeDetailDialogState.Report(
                                    comment = reportState.comment,
                                    report = it,
                                    memberId = reportState.memberId
                                )
                            }

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
//            Image(
//                modifier = Modifier
//                    .size(16.dp)
//                    .clickable {
//                        openBottomSheet = NoticeDetailModalState.More
//                    },
//                imageVector = KusitmsIcons.MoreVertical,
//                contentDescription = "더보기"
//            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ,
            contentPadding = PaddingValues(top = 20.dp),
            state = listState
        ) {
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
                    color = KusitmsColorPalette.current.Grey300
                )
            }

            item {
                KusitmsMarginVerticalSpacer(size = 32)
                if (!notice.imageUrl.isNullOrEmpty()) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentPadding = PaddingValues(start = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(notice.imageUrl ?: emptyList()){
                            NoticeDetailImageCard(
                                it,
                                onClickImage = {
                                    imageViewerViewModel.updateImageList(notice.imageUrl ?: emptyList())
                                    onClickImage()
                                }
                            )
                        }
                    }
                    KusitmsMarginVerticalSpacer(size = 8)
                    Text(
                        modifier = Modifier.padding(start = 28.dp),
                        text = "1/1",
                        style = KusitmsTypo.current.Caption2,
                        color = KusitmsColorPalette.current.Grey500
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
            ) { index, comment ->
                if (index == 0) {
                    KusitmsMarginVerticalSpacer(size = 20)
                }
                NoticeComment(
                    comment = comment,
                    onClickReport = {
                        openBottomSheet =
                            NoticeDetailModalState.Report(comment, comment.writerId)
                    },
                    onClickDelete = {
                        openDialogState = NoticeDetailDialogState.CommentDelete(comment)
                    },
                    onClickChildComment = {
                        openBottomSheet =
                            NoticeDetailModalState.Comment(comment)
                    },
                    isLast = index == commentList.lastIndex
                )
                if (index == commentList.lastIndex && index != 0) {
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
            ) {
                Text(
                    text = notice.curriculum,
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Main2_500
                )
                KusitmsMarginHorizontalSpacer(size = 8)
                Text(
                    text = notice.team,
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey300
                )
            }
            Text(
                text = notice.title,
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color = KusitmsColorPalette.current.Grey200
            )
            KusitmsMarginVerticalSpacer(size = 12)
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(notice.profileImage)
                        .crossfade(true)
                        .build(),
                    error = rememberVectorPainter(image = KusitmsIcons.UserBackground),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(16.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
                KusitmsMarginHorizontalSpacer(size = 4)
                Text(
                    modifier = Modifier.weight(1f),
                    text = notice.name,
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400
                )
                Text(
                    text = notice.date,
                    style = KusitmsTypo.current.Caption2,
                    color = KusitmsColorPalette.current.Grey400
                )
            }
        }

    }
}

@Composable
fun NoticeDetailImageCard(
    imageUrl: String,
    onClickImage: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable {
                onClickImage()
            },
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
