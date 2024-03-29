package com.kusitms.presentation.ui.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.profile.ProfileModel

@Composable
fun ProfileListScreen(
    profileList: List<ProfileModel>,
    onProfileClick: (ProfileModel) -> Unit,
) {
    val listState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 152.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp),
        state = listState
    ) {
        if (profileList.isNotEmpty()) {
            items(profileList) { profile ->
                ProfileItem(
                    profile = profile,
                    onClick = {
                        onProfileClick(profile)
                    }
                )
            }
        }
    }
}

