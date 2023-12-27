package com.kusitms.presentation.ui.profile.detail

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.size.Size
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun ProfileDetailInfo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(size = 24.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 8.dp)
        ) {
            Text(
                text = "프로필",
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color = KusitmsColorPalette.current.White,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "전공",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                Text(
                    text = "시각디자인과",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey100
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "관심",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                Text(
                    text = "UXUI 디자인, 데이터분석,\n" +
                            "스타트업",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey100
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "이메일",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 24.dp)
                )
                Text(
                    text = "chaeyeon_123@naver.com",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey100
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "번호",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                Text(
                    text = "010-1234-1234",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey100
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "링크",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                ProfileLink(imageResId = R.drawable.ic_notion, uri = "https://www.notion.so/ko-kr")
                Box(modifier = Modifier.width(4.dp))
                ProfileLink(imageResId = R.drawable.ic_notion, uri = "https://www.notion.so/ko-kr")
            }
        }
    }
}

@Composable
fun ProfileLink(@DrawableRes imageResId: Int, uri: String) {
    val uriHandler = LocalUriHandler.current
    Box(
        modifier = Modifier
            .width(49.dp)
            .height(41.dp)
            .background(
                color = KusitmsColorPalette.current.Grey500,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { uriHandler.openUri(uri) }
    ) {
        Image(
            painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            alignment = Alignment.Center
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileDetailInfoPreview() {
    ProfileDetailInfo()
}