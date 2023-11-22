package com.kusitms.presentation.ui.notice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.notice.NoticeUiModel
import com.kusitms.presentation.model.notice.noticeDummy

@Composable
fun ColumnScope.NoticeList(){
    LazyColumn(
        modifier = Modifier.background(KusitmsColorPalette.current.Grey900),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            KusitmsMarginVerticalSpacer(size = 16)

            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.Red)
                )
                KusitmsMarginHorizontalSpacer(size = 10)
                Text(
                    text = "큐시즘의 공지사항, 빠른 확인해주세요!",
                    style = KusitmsTypo.current.Text_Semibold,
                    color =  KusitmsColorPalette.current.Grey300
                )
            }
        }
        item {
            KusitmsMarginVerticalSpacer(size = 40)

            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(
                    modifier = Modifier
                        .size(20.dp)
                        .background(Color.White)
                )
                KusitmsMarginHorizontalSpacer(size = 10)
                Text(
                    text = "안 읽은 공지만 보기",
                    style = KusitmsTypo.current.Caption1,
                    color =  KusitmsColorPalette.current.Grey400
                )
            }
        }
        items(noticeDummy){
            KusitmsNoticeItem(
                notice = it,
                onClick = {

                }
            )
        }
    }
}


@Composable
fun KusitmsNoticeItem(
    notice : NoticeUiModel,
    onClick : (NoticeUiModel) -> Unit
){
    Column(
        modifier = Modifier.clickable {
            onClick(notice)
        }.padding(vertical = 16.dp).alpha(
            if(notice.isRead) 0.5f else 1f
        )
    ) {
        Row(
            modifier = Modifier.height(34.dp),
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
                color =  KusitmsColorPalette.current.Grey400
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = notice.date,
                style = KusitmsTypo.current.Caption2,
                color =  KusitmsColorPalette.current.Grey500
            )
        }

        KusitmsMarginVerticalSpacer(size = 4)
        Text(
            text = notice.title,
            style = KusitmsTypo.current.Text_Semibold,
            color =  KusitmsColorPalette.current.White
        )
        KusitmsMarginVerticalSpacer(size = 4)
        Text(
            text = notice.content,
            style = KusitmsTypo.current.Caption1,
            color =  KusitmsColorPalette.current.Grey400,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}