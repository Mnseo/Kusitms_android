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
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.search.ProfileSearchViewModel
import com.kusitms.presentation.ui.profile.ProfileItem

@Composable
fun ProfileSearchExist(
    viewModel: ProfileSearchViewModel,
    onProfileClick: (ProfileModel) -> Unit
) {
    val searchedProfiles = viewModel.getSearchProfiles()

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
                text = searchedProfiles.size.toString(),
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
            items(searchedProfiles) { profile ->
                ProfileItem(
                    profile = profile,
                    onClick = { onProfileClick(profile) }
                )
            }
        }
    }
}
