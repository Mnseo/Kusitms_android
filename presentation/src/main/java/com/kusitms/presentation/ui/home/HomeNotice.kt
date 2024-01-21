package com.kusitms.presentation.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

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

@OptIn(ExperimentalAnimationApi::class)
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

            if (notice.isNotEmpty()) {
                Column {
                    AnimatedContent(
                        targetState = notice[currentNoticeIndex.value].title,
                        transitionSpec = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween(durationMillis = 500)
                            ) togetherWith
                                    slideOutOfContainer(
                                        towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                        animationSpec = tween(durationMillis = 500)
                                    )
                        },
                        contentAlignment = Alignment.Center
                    ) { targetCount ->
                        Column {
                            Text(
                                text = targetCount,
                                style = KusitmsTypo.current.Text_Semibold,
                                color = KusitmsColorPalette.current.White,
                                modifier = Modifier.clickable { }
                            )
                        }
                    }

                    AnimatedContent(
                        targetState = notice[nextNoticeIndex.value].title,
                        transitionSpec = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween(durationMillis = 500)
                            ) togetherWith
                                    slideOutOfContainer(
                                        towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                        animationSpec = tween(durationMillis = 500)
                                    )
                        },
                        contentAlignment = Alignment.Center
                    ) { targetCount ->

                        Text(
                            text = targetCount,
                            style = KusitmsTypo.current.Text_Semibold,
                            color = KusitmsColorPalette.current.White,
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                                .height(16.dp)
                                .background(
                                    brush = verticalGradient(
                                        0f to KusitmsColorPalette.current.Grey900.copy(alpha = 0f),
                                        0.7f to KusitmsColorPalette.current.Grey900,
                                        tileMode = TileMode.Clamp
                                    )
                                )
                        )
                    }
                }
            } else {
                Text(
                    text = stringResource(R.string.home_notice),
                    style = KusitmsTypo.current.Text_Semibold,
                    color = KusitmsColorPalette.current.White
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