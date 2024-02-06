package com.kusitms.presentation.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun ProfileItem(
    profile: ProfileModel,
    modifier: Modifier = Modifier,
    onClick: (ProfileModel) -> Unit,
) {
    Column(
        modifier = Modifier
            .then(modifier)
            .padding(vertical = 32.dp, horizontal = 16.dp)
            .clickable {
                onClick(profile)
            }
            .fillMaxWidth(),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey100,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            Box {
                // 통신으로 가져오는 이미지
                AsyncImage(
                    model = profile.profileImage,
                    contentDescription = stringResource(id = R.string.profile_picture),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(152.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = profile.name,
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.White
            )
            Text(
                text = mapPartToKorean(part = profile.part),
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
        }
        Text(
            text = profile.description,
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400,
            maxLines = 2
        )
    }
}


// 파트 이름을 한글로 바꾸는 함수
@Composable
private fun mapPartToKorean(part: String): String {
    return when (part) {
        "PLANNING" -> "기획자"
        "DESIGN" -> "디자이너"
        "DEVELOPMENT" -> "개발자"
        else -> part
    }
}