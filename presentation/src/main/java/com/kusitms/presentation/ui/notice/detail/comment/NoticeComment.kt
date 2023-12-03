package com.kusitms.presentation.ui.notice.detail.comment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.notice.CommentUiModel


@Composable
fun NoticeComment(
    comment: CommentUiModel,
    isLast : Boolean = false,
    isParentCommentAsReply : Boolean = false
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = 16.dp,
                    horizontal = if (isParentCommentAsReply) 12.5.dp else 20.dp
                )
        ) {
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
                KusitmsMarginHorizontalSpacer(size = 8)
                Text(
                    text = comment.writer,
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Grey400
                )
                KusitmsMarginHorizontalSpacer(size = 8)
                Text(
                    modifier = Modifier.weight(1f),
                    text = comment.createdAt,
                    textAlign = TextAlign.Start,
                    style = KusitmsTypo.current.Caption2,
                    color =  KusitmsColorPalette.current.Grey400
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .clickable {

                        },
                    text = if(comment.isMine) "삭제" else "신고",
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.GreyBlack7
                )

            }
            KusitmsMarginVerticalSpacer(size = 8)
            Text(
                modifier = Modifier
                    .padding(start = 32.dp,end = 24.dp),
                text = comment.content,
                style = KusitmsTypo.current.Body2,
                color =  KusitmsColorPalette.current.Grey100
            )
            KusitmsMarginVerticalSpacer(size = 12)
            Row(
                modifier = Modifier.padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = KusitmsColorPalette.current.Grey400)
                )
                KusitmsMarginHorizontalSpacer(size = 4)
                Text(
                    text ="${comment.commentCount}",
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.GreyBlack7
                )
            }
        }
        if(!isLast)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .align(Alignment.BottomCenter),
                color = KusitmsColorPalette.current.Grey600
            )
    }
}

@Composable
fun CommentInput(
    onClickSend : (String) -> Unit
){
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
    var isAnonymous by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(KusitmsColorPalette.current.Grey700)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Card(
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .padding(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey600,
                contentColor = KusitmsColorPalette.current.Grey400
            )
        ) {
            Row(
                modifier = Modifier.padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                BasicTextField(
                    modifier = Modifier.weight(1f).padding(vertical = 12.dp),
                    value = textFieldValue,
                    onValueChange = {
                        textFieldValue = it
                    },
                    textStyle = KusitmsTypo.current.Body1.copy(
                        color = KusitmsColorPalette.current.Grey100
                    ),
                    decorationBox = { innerTextField ->
                        if(textFieldValue.text.isEmpty()){
                            Text(
                                text ="댓글을 작성해주세요",
                                style = KusitmsTypo.current.Body1,
                                color =  KusitmsColorPalette.current.Grey400
                            )
                        }
                        innerTextField()
                    }

                )
                KusitmsMarginHorizontalSpacer(size = 10)

                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(2.dp))
                        .padding(vertical = 6.dp)
                        .clickable {
                            isAnonymous = !isAnonymous
                        }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text ="익명",
                        style = KusitmsTypo.current.Caption1,
                        color =  if(isAnonymous) KusitmsColorPalette.current.Main500 else KusitmsColorPalette.current.Grey400
                    )
                    KusitmsMarginHorizontalSpacer(size = 4)
                    Spacer(
                        modifier = Modifier
                            .size(20.dp)
                            .background(color = if(isAnonymous) KusitmsColorPalette.current.Main500 else KusitmsColorPalette.current.Grey400)
                    )
                }
            }
        }

        KusitmsMarginHorizontalSpacer(size = 8)
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp)).clickable {
                    onClickSend(textFieldValue.text)
                }.padding(16.dp),
            contentAlignment = Alignment.Center
        ){
            Spacer(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = KusitmsColorPalette.current.Grey100)
            )
        }

    }
}