package com.kusitms.presentation.ui.viewer

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.os.Environment.DIRECTORY_DOWNLOADS
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.kusitms.presentation.common.util.FileDownloadUtil
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Download
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageViewerScreen(
    viewModel: ImageViewerViewModel,
    onShowSnackbar : suspend (String) -> Unit,
    onBack: () -> Unit
) {
    val imageList by viewModel.imageList.collectAsStateWithLifecycle()
    val imageHorizontalPager = rememberPagerState(
        initialPage = viewModel.selectedIndex,
        pageCount = {
            imageList.size
        }
    )
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit){
        viewModel.snackbarEvent.collect {
            onShowSnackbar(
                when(it){
                    ImageViewerViewModel.Companion.ImageViewerSnackbarEvent.DOWNLOAD_ERROR ->
                        "다운로드 도중 에러가 발생하였습니다."
                }
            )
        }
    }

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
                        try {
                            FileDownloadUtil.downloadImage(
                                downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager,
                                url = imageList.get(imageHorizontalPager.currentPage),
                                file = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS)
                            )
                        }catch (e: Exception){
                            viewModel.emitSnackbarEvent(ImageViewerViewModel.Companion.ImageViewerSnackbarEvent.DOWNLOAD_ERROR)
                        }

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