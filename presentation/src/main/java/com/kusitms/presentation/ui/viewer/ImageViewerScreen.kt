package com.kusitms.presentation.ui.viewer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Download

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageViewerScreen(
    viewModel: ImageViewerViewModel,
    onBack: () -> Unit
) {
    val imageList by viewModel.imageList.collectAsStateWithLifecycle()
    val imageHorizontalPager = rememberPagerState(
        initialPage = viewModel.selectedIndex,
        pageCount = {
            imageList.size
        }
    )

    if(imageList.isEmpty()) return

    Column(
        modifier = Modifier.fillMaxSize().background(KusitmsColorPalette.current.Grey800)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        onBack()
                    },
                imageVector = KusitmsIcons.Close,
                contentDescription = "닫기"
            )
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = "${imageHorizontalPager.currentPage + 1}/${imageList.size}",
                textAlign = TextAlign.Center,
                style = KusitmsTypo.current.SubTitle1_Semibold,
                color = KusitmsColorPalette.current.Grey100
            )
            Image(
                modifier = Modifier
                    .size(20.dp)
                    .clickable {

                    },
                imageVector = KusitmsIcons.Download,
                contentDescription = "다운로드"
            )
        }
        HorizontalPager(state = imageHorizontalPager) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageList.get(it) ?: "")
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    error = painterResource(id = R.drawable.rectangle_grey_500),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }


        }

    }
}