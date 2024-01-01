package com.kusitms.presentation.ui.profile.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.Profile
import com.kusitms.presentation.ui.profile.ProfileItem

@Composable
fun ProfileSearchExist(
) {
    val profiles = listOf(
        Profile(0, "이채연", "디자이너", "디자이너 한 줄 소개"),
        Profile(1, "국준호", "기획자", "기획자 한 줄 소개"),
        Profile(2, "장세은", "개발자", "개발자 한 줄 소개"),
        Profile(3, "이안진", "개발자", "개발자 한 줄 소개"),
        Profile(4, "신민서", "개발자", "개발자 한 줄 소개"),
        Profile(5, "김서연", "기획자", "기획자 한 줄 소개"),
        Profile(6, "안정후", "개발자", "개발자 한 줄 소개"),
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "1",
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
            Text(
                text = "명의 프로필이 있어요",
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 152.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 0.dp),
        ) {
            items(profiles) { profile ->
                ProfileItem(
                    profile = profile,
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileSearchExistPriview(
) {
    ProfileSearchExist()
}