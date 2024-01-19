package com.kusitms.presentation.ui.notice.detail.vote

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.notice.NoticeVoteItem
import com.kusitms.domain.model.notice.NoticeVoteModel
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Selected

@Composable
fun NoticeVote(
    noticeVoteModel: NoticeVoteModel = NoticeVoteModel(title = "테스트", total = 3, items = listOf(
        NoticeVoteItem(item = "테스크1"),NoticeVoteItem(item = "테스크2"),NoticeVoteItem(item = "테스크3"),NoticeVoteItem(item = "테스크4"),NoticeVoteItem(item = "테스크5")
    ))
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
                NoticePreVoteItem(
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

@Composable
fun NoticeVotedItem() {

}