package com.kusitms.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeNotice(
    notice: List<NoticeRecentModel>,
    currentNoticeIndex: State<Int>,
    nextNoticeIndex: State<Int>,
) {
    if (notice.isNotEmpty()) {
        HomeNoticeExist(
            notice = notice,
            currentNoticeIndex = currentNoticeIndex,
            nextNoticeIndex = nextNoticeIndex
        )
    } else {
        HomeNoticeNone()
    }
}


@Composable
fun HomeNoticeExist(
    notice: List<NoticeRecentModel>,
    currentNoticeIndex: State<Int>,
    nextNoticeIndex: State<Int>,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey900,
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_notice),
                contentDescription = stringResource(id = R.string.home_ic_notice),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = notice[currentNoticeIndex.value].title,
                    style = KusitmsTypo.current.Text_Semibold,
                    color = KusitmsColorPalette.current.White
                )
                Text(
                    text = notice[nextNoticeIndex.value].title,
                    style = KusitmsTypo.current.Text_Semibold,
                    color = KusitmsColorPalette.current.White,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }
        }
    }
}


@Composable
fun HomeNoticeNone() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey900,
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_notice),
                    contentDescription = stringResource(id = R.string.home_ic_notice),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.home_notice),
                    style = KusitmsTypo.current.Text_Semibold,
                    color = KusitmsColorPalette.current.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Preview
@Composable
fun HomeNoticeExistPreview() {
    HomeNoticeNone(
    )
}