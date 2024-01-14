package com.kusitms.presentation.ui.profile.detail

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.profile.InterestModel
import com.kusitms.domain.model.profile.LinkModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun ProfileDetailInfo(
    major: String,
    interests: List<InterestModel>,
    email: String,
    phoneNumber: String,
    links: List<LinkModel>,
) {
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
                text = stringResource(id = R.string.profile_detail_profile),
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
                    text = stringResource(id = R.string.profile_detail_major),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                Text(
                    text = major,
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
                    text = stringResource(id = R.string.profile_detail_like),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                Text(
                    text = interests.joinToString(", ") { it.content },
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
                    text = stringResource(id = R.string.profile_detail_email),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 24.dp)
                )
                Text(
                    text = email,
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
                    text = stringResource(id = R.string.profile_detail_phone),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                Text(
                    text = phoneNumber,
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
                    text = stringResource(id = R.string.profile_detail_link),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400,
                    modifier = Modifier
                        .padding(end = 36.dp)
                )
                if (links.isEmpty()) {
                    Text(
                        text = stringResource(id = R.string.profile_detail_link_none),
                        style = KusitmsTypo.current.Caption1,
                        color = KusitmsColorPalette.current.Grey400
                    )
                } else {
                    links.forEach { link ->
                        if (link.link.startsWith("https://")) {
                            ProfileLink(link = link)
                        } else {
                            Text(
                                text = stringResource(id = R.string.profile_detail_link_none),
                                style = KusitmsTypo.current.Caption1,
                                color = KusitmsColorPalette.current.Grey400
                            )
                        }
                        Box(modifier = Modifier.width(4.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileLink(link: LinkModel) {
    val uriHandler = LocalUriHandler.current

    val imageResId = when (link.type) {
        "LINK" -> R.drawable.ic_link
        "BRUNCH" -> R.drawable.ic_brunch
        "TISTORY" -> R.drawable.ic_tistory
        "BEHANCE" -> R.drawable.ic_behance
        "LINKEDIN" -> R.drawable.ic_linkedin
        "GITHUB" -> R.drawable.ic_github
        "NOTION" -> R.drawable.ic_notion
        else -> R.drawable.ic_warning_sigb // 기본값
    }

    Box(
        modifier = Modifier
            .width(49.dp)
            .height(41.dp)
            .background(
                color = KusitmsColorPalette.current.Grey500,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { uriHandler.openUri(link.link) }
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
