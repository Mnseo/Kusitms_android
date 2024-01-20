package com.kusitms.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeNotice() {

}


@Composable
fun HomeNoticeExist() {
    val notice: List<NoticeRecentModel> = listOf(
        NoticeRecentModel("공지 0", 0),
        NoticeRecentModel("공지 1", 1),
        NoticeRecentModel("공지 0", 2)
    )
    var currentNoticeIndex by remember {
        mutableStateOf(0)
    }
    var nextNoticeIndex by remember {
        mutableStateOf((currentNoticeIndex + 1) % notice.size)
    }
    var isTransitioning by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(currentNoticeIndex) {
        coroutineScope.launch {
            delay(3000)
            isTransitioning = true
            delay(200)
            currentNoticeIndex = nextNoticeIndex
            nextNoticeIndex = (currentNoticeIndex + 1) % notice.size
            isTransitioning = false
        }
    }

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
                    text = notice[currentNoticeIndex].title,
                    style = KusitmsTypo.current.Text_Semibold,
                    color = KusitmsColorPalette.current.White
                )

                if (isTransitioning) {
                    val alpha = 1f - (200 / 300f) // 200ms transition duration
                    Text(
                        text = notice[nextNoticeIndex].title,
                        style = KusitmsTypo.current.SubTitle1_Medium,
                        color = KusitmsColorPalette.current.White,
                        modifier = Modifier
                            .graphicsLayer(alpha = alpha)
                            .padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeNoticeExistPreview() {
    HomeNoticeExist()
}