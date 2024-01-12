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
import androidx.navigation.NavController
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.profile.ProfileItem

@Composable
fun ProfileSearchExist(
    navController: NavController,
    profileList: List<ProfileModel>
) {

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
                text = profileList.size.toString(),
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
            items(profileList) { profile ->
                ProfileItem(
                    profile = profile,
                    onClick = { navController.navigate(NavRoutes.ProfileDetail.route) }
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileSearchExistPriview(
) {
//    ProfileSearchExist()
}