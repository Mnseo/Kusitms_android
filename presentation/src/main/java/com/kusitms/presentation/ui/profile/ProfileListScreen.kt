package com.kusitms.presentation.ui.profile

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTheme
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.Profile

@Composable
fun ProfileListScreen(navController: NavController) {
    val profiles = listOf(
        Profile("이채연", "디자이너", "디자이너 한 줄 소개"),
        Profile("국준호", "기획자", "기획자 한 줄 소개"),
        Profile("장세은", "개발자", "개발자 한 줄 소개"),
        Profile("이안진", "개발자", "개발자 한 줄 소개"),
        Profile("신민서", "개발자", "개발자 한 줄 소개"),
        Profile("김서연", "기획자", "기획자 한 줄 소개"),
        Profile("안정후", "개발자", "개발자 한 줄 소개"),
        )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 152.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp),
    ) {
        items(profiles) { profile ->
            ProfileItem(
                profile = profile,
                onClick = { navController.graph })
        }
    }
}

@Composable
fun ProfileItem(profile: Profile, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .then(modifier)
            .padding(vertical = 32.dp, horizontal = 16.dp)
            .fillMaxWidth(),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey100,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(152.dp)
                        .background(KusitmsColorPalette.current.Grey100)
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
                text = profile.part,
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
        }
        Text(
            text = profile.introduction,
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
    }
}

@Preview
@Composable
fun ProfileItemPreview() {
    KusitmsTheme {
        ProfileItem(
            profile = Profile("이채연", "디자이너", "디자이너 한 줄 소개"),
            onClick = {}
        )
    }
}