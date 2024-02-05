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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.notice.detail.comment.CommentInput
import com.kusitms.presentation.ui.notice.detail.comment.NoticeComment

@Composable
fun BottomSheetDrawerBar(
    modifier: Modifier= Modifier
){
    Spacer(modifier = modifier
        .width(132.dp)
        .height(4.dp)
        .background(KusitmsColorPalette.current.Grey400))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoticeCommentBottom(
    noticeDetailViewModel: NoticeDetailViewModel = hiltViewModel(),
    targetComment : CommentModel,
    onClickChildReport : (NoticeDetailModalState.Report) -> Unit,
    onClickChildDelete : (NoticeDetailDialogState.CommentDelete) -> Unit
){
    val childCommentList by noticeDetailViewModel.childCommentList.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = targetComment.commentId){
        noticeDetailViewModel.clearChildCommentList()
        noticeDetailViewModel.fetchChildCommentList(
            targetComment.commentId
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .systemBarsPadding()
            .fillMaxHeight()

    ) {
        BottomSheetDrawerBar(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp)
        )
        KusitmsMarginVerticalSpacer(size = 20)
        NoticeComment(
            comment = targetComment,
            commentCount = childCommentList.size,
            isParentCommentAsReply = true
        )
        KusitmsMarginVerticalSpacer(size = 20)

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = KusitmsColorPalette.current.Grey600
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            itemsIndexed(
                childCommentList
            ) { index, comment ->
                if (index == 0) {
                    KusitmsMarginVerticalSpacer(size = 20)
                }
                NoticeComment(
                    comment = comment,
                    onClickReport = {
                        onClickChildReport(
                            NoticeDetailModalState.Report(comment, comment.writerId)
                        )
                    },
                    onClickDelete = {
                        onClickChildDelete(
                            NoticeDetailDialogState.CommentDelete(
                                comment = comment,
                                parentComment = targetComment
                            )
                        )

                    },
                    isLast = index == childCommentList.lastIndex
                )
                if (index == childCommentList.lastIndex && index != 0) {
                    KusitmsMarginVerticalSpacer(size = 20)
                }
            }
        }
        CommentInput(
            modifier = Modifier.padding(bottom = 42.dp),
            onClickSend = {
                noticeDetailViewModel.addNoticeChildComment(targetComment.commentId,it)
            }
        )
    }
}

@Composable
fun NoticeMoreBottom(
    onClickEdit: () -> Unit = {},
    onClickDelete: () -> Unit = {}
) {
    var isDeleteMode by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .systemBarsPadding()
    ) {
        if (!isDeleteMode) {
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
        } else {
            KusitmsMarginVerticalSpacer(size = 16)
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "공지 삭제하기",
                style = KusitmsTypo.current.SubTitle1_Semibold,
                color = KusitmsColorPalette.current.Grey100
            )
            KusitmsMarginVerticalSpacer(size = 8)
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "해당 공지 글이 삭제됩니다.",
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey300
            )
            KusitmsMarginVerticalSpacer(size = 40)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)

            ) {
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
                    Text(
                        text = "취소하기",
                        style = KusitmsTypo.current.Text_Semibold,
                        color = KusitmsColorPalette.current.Grey200
                    )
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
                    Text(
                        text = "삭제하기",
                        style = KusitmsTypo.current.Text_Semibold,
                        color = KusitmsColorPalette.current.Grey600
                    )
                }
            }
        }
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun NoticeCommentReportBottom(
    onClick: (ReportCategory) -> Unit = {},
    onDismiss: () -> Unit
) {
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
        ) {
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "신고 사유 선택",
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color = KusitmsColorPalette.current.Grey300
            )
            Spacer(
                modifier = Modifier
                    .height(0.dp)
                    .weight(1f)
            )
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
        ReportCategory.values().forEach {
            ModalTextBox(
                text = stringResource(id = it.titleId),
                boxPadding = PaddingValues(horizontal = 12.5.dp),
                onClick = {
                    onClick(it)
                    onDismiss()
                }
            )
        }
        KusitmsMarginVerticalSpacer(size = 24)
    }
}


@Composable
fun ModalTextBox(
    text: String,
    boxPadding: PaddingValues = PaddingValues(horizontal = 20.dp),
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable {
                onClick()
            }
            .padding(boxPadding),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = text,
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Grey100
        )
    }
}