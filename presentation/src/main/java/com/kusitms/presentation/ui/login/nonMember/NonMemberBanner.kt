package com.kusitms.presentation.ui.login.nonMember

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.nonmember.Channel
import com.kusitms.presentation.model.login.nonmember.Channels.channels

@Composable
fun NonMemberBanner() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(154.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        InstaYoutubeRow(channels)
        Spacer(modifier = Modifier.height(12.dp))
        KusitmsNaverCafe()
    }
}

@Composable
fun InstaYoutubeRow(channels: List<Channel>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        channels.take(2).forEach { channel ->
            channelItem(
                imageResId = channel.imageRes,
                stringRes = channel.stringRes,
                modifier = Modifier.weight(1f),
                uri = channel.uri
            )
        }
    }
}

@Composable
fun channelItem(@DrawableRes imageResId:Int, @StringRes stringRes:Int, modifier: Modifier, uri:String) {
    val uriHandler = LocalUriHandler.current
    Box(modifier = modifier
        .height(60.dp)
        .background(
            color = KusitmsColorPalette.current.Grey600,
            shape = RoundedCornerShape(size = 16.dp)
        )
        .clickable { uriHandler.openUri(uri) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painterResource(id = imageResId),
                tint = Color.Unspecified,
                contentDescription = null
            )
            Text(
                text= stringResource(id = stringRes),
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey100
            )

        }
    }
}

@Composable
fun KusitmsNaverCafe() {
    val uriHandler = LocalUriHandler.current
    Box(modifier = Modifier
        .height(80.dp)
        .background(
            color = KusitmsColorPalette.current.Grey600,
            shape = RoundedCornerShape(size = 16.dp)
        )
        .clickable {
            uriHandler.openUri("https://cafe.naver.com/kusitms")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(13.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painterResource(id = R.drawable.ic_nonmember_chat),
                tint = Color.Unspecified,
                contentDescription = null
            )
            Text(
                text= stringResource(id = R.string.nonMember_banner3),
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey100
            )

        }
    }
}

@Preview
@Composable
fun PreviewBanner() {
    NonMemberBanner()
}