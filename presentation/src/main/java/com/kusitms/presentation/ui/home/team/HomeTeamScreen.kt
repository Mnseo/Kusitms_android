package com.kusitms.presentation.ui.home.team

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.home.team.HomeTeamViewModel
import com.kusitms.presentation.ui.profile.ProfileListScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun HomeTeamDetailScreen(
    viewModel: HomeTeamViewModel = hiltViewModel(),
    onBack: () -> Unit,
    curriculumName: String,
    onProfileClick: (ProfileModel) -> Unit,
) {
    val profileList by viewModel.profileList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey700)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = curriculumName,
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey100,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                shape = RoundedCornerShape(4.dp), colors = CardDefaults.cardColors(
                    containerColor = KusitmsColorPalette.current.Grey500,
                )
            ) {
                Box(modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text(
                        text = profileList.size.toString(),
                        style = KusitmsTypo.current.Caption1,
                        color = KusitmsColorPalette.current.Main400,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painterResource(id = R.drawable.ic_hide),
                modifier = Modifier
                    .clickable {
                        onBack()
                    },
                contentDescription = null
            )
        }
        Text(
            text = "나와 함께한 팀원들이에요\n클릭하면 상세프로필을 볼 수 있어요",
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            ProfileListScreen(profileList = profileList,
                onProfileClick = { profile ->
                    onProfileClick(profile)
                })
        }
    }
}

@Preview
@Composable
fun HomeTeamDeatilScreenPreview() {
    HomeTeamDetailScreen(
        onBack = {},
        curriculumName = "",
        onProfileClick = {}
    )
}