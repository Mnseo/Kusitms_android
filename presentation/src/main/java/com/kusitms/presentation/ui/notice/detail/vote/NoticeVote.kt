package com.kusitms.presentation.ui.notice.detail.vote

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kusitms.domain.model.notice.NoticeVoteItem
import com.kusitms.domain.model.notice.NoticeVoteMember
import com.kusitms.domain.model.notice.NoticeVoteModel
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Selected
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.UserBackground

@Composable
fun NoticeVote(
    noticeVoteModel: NoticeVoteModel = NoticeVoteModel()
) {
    var selectedNoteVoteItemList by remember { mutableStateOf<List<NoticeVoteItem>>(emptyList()) }

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
            Modifier.padding(horizontal = 16.dp, vertical = 28.dp)
        ) {
            Text(
                text = noticeVoteModel.title,
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey100
            )
            KusitmsMarginVerticalSpacer(size = 16)
            noticeVoteModel.items.forEach {
                NoticeVotedItem(
                    it,
                    selectedNoteVoteItemList.contains(it),
                    onClick = {
                        selectedNoteVoteItemList = if(selectedNoteVoteItemList.contains(it)) emptyList() else listOf(it)
                    }
                )
                KusitmsMarginVerticalSpacer(size = 4)
            }
            KusitmsMarginVerticalSpacer(size = 12)
            OutlinedButton(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = KusitmsColorPalette.current.Grey600,
                    contentColor =  KusitmsColorPalette.current.Grey200,
                    disabledContentColor =   KusitmsColorPalette.current.Grey500
                ),
                border = BorderStroke(1.dp, color =
                    KusitmsColorPalette.current.Grey500
                ),
                enabled = selectedNoteVoteItemList.isNotEmpty(),
                onClick = {

                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "투표하기",
                        style = KusitmsTypo.current.SubTitle2_Semibold,
                    )
                }
            }
            KusitmsMarginVerticalSpacer(size = 16)
            Text(
                text = "${noticeVoteModel.total}명 참여",
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
        }

    }
}

@Composable
fun NoticePreVoteItem(
    noticeVoteItem : NoticeVoteItem,
    isSelected : Boolean,
    onClick : (NoticeVoteItem) -> Unit
) {
    OutlinedCard(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .clickable {
                onClick(noticeVoteItem)
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if(isSelected) KusitmsColorPalette.current.Grey500 else KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey200
        ),
        border = BorderStroke(1.dp, color = KusitmsColorPalette.current.Grey500)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = noticeVoteItem.item,
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey100
            )
            if(isSelected){
                KusitmsMarginHorizontalSpacer(size = 12)
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = KusitmsIcons.Selected,
                    contentDescription = "선택"
                )
            }

        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NoticeVotedItem(
    noticeVoteItem : NoticeVoteItem,
    isSelected : Boolean,
    onClick : (NoticeVoteItem) -> Unit
) {
    var isExpandedMemberPopUp by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    OutlinedCard(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .let {
                if(!isExpandedMemberPopUp) it.clickable {
                    isExpandedMemberPopUp = true
                } else it
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey200
        ),
        border = BorderStroke(1.dp,
            color = if(isSelected) KusitmsColorPalette.current.Main500 else KusitmsColorPalette.current.Grey500
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            KusitmsMarginVerticalSpacer(size = 12)
            Row(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(isSelected){
                    Image(
                        modifier = Modifier
                            .size(24.dp),
                        imageVector = KusitmsIcons.Selected,
                        contentDescription = "선택"
                    )
                    KusitmsMarginHorizontalSpacer(size = 12)
                }
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f),
                    text = noticeVoteItem.item,
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Grey100
                )
                KusitmsMarginHorizontalSpacer(size = 12)
                Text(
                    text = "${noticeVoteItem.count}명",
                    style = KusitmsTypo.current.Text_Medium,
                    color = if(isSelected) KusitmsColorPalette.current.Main500 else KusitmsColorPalette.current.Grey400
                )
                KusitmsMarginHorizontalSpacer(size = 4)
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = KusitmsIcons.ArrowDown,
                    contentDescription = "선택"
                )
            }
            Box(){
                KusitmsMarginVerticalSpacer(size = 12)
                if(isExpandedMemberPopUp){
                    Popup(
                        alignment = Alignment.TopCenter,
                        onDismissRequest = {
                            isExpandedMemberPopUp = false
                        }
                    ) {
                        Card(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .padding(horizontal = 36.dp)
                                .heightIn(max = 144.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = KusitmsColorPalette.current.Grey500
                            )
                        ) {
                            FlowRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .verticalScroll(scrollState)
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                verticalArrangement = Arrangement.spacedBy(24.dp)
                            ) {
                                noticeVoteItem.members.forEach {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(it.profileImageUrl)
                                                .crossfade(true)
                                                .build(),
                                            error = rememberVectorPainter(image = KusitmsIcons.UserBackground),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(24.dp)
                                                .clip(RoundedCornerShape(4.dp))
                                        )
                                        KusitmsMarginHorizontalSpacer(size = 8)
                                        Text(
                                            text = it.name,
                                            style = KusitmsTypo.current.Text_Medium,
                                            color = KusitmsColorPalette.current.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}