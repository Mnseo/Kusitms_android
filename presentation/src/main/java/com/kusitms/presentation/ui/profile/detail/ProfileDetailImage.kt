package com.kusitms.presentation.ui.profile.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun ProfileDetailImage(
    name: String,
    profileImage: String,
    part: String,
    description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(463.dp)
            .background(
                color = KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(size = 24.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_logo),
                contentDescription = null,
            )
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = KusitmsColorPalette.current.Grey100,
                    contentColor = KusitmsColorPalette.current.Grey100
                )
            ) {
                Box {
                    AsyncImage(
                        model = profileImage,
                        contentDescription = stringResource(id = R.string.profile_picture),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(182.dp)
                            .height(182.dp)
                    )
                }
            }
            Text(
                text = name,
                style = KusitmsTypo.current.Header1,
                color = KusitmsColorPalette.current.White
            )
            Text(
                text = part,
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey400
            )

            if (description.isEmpty()) {
                Text(
                    text = stringResource(R.string.profile_detail_info_none),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey300,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 28.dp)
                )
            } else {
                Text(
                    text = description,
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey300,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 28.dp)
                )
            }
        }
    }
}
