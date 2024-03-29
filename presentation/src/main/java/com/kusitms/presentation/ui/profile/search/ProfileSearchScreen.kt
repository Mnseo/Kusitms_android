package com.kusitms.presentation.ui.profile.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.search.ProfileSearchViewModel
import com.kusitms.presentation.ui.ImageVector.LeftArrow

@Composable
fun ProfileSearchScreen(
    viewModel: ProfileSearchViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onProfileClick: (ProfileModel) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()
    val profileList by viewModel.profileList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onBackClick()
                    },
                imageVector = LeftArrow.vector,
                contentDescription = stringResource(id = R.string.profile_search_back)
            )
            Spacer(modifier = Modifier.width(16.dp))
            ProfileSearchField(
                text = uiState.value.searchText,
                onTextChange = { newText ->
                    viewModel.changeSearchText(newText)
                },
                onClearClick = {
                    viewModel.clearSearchText()
                }
            )
        }
        if (uiState.value.searchText.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.profile_search_none),
                    textAlign = TextAlign.Center,
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400
                )
            }
        } else {
            if (viewModel.profilesContainsSearchText(uiState.value.searchText, profileList)) {
                ProfileSearchExist(
                    viewModel = viewModel,
                    onProfileClick = { profile ->
                        onProfileClick(profile)
                    }
                )
            } else {
                ProfileSearchNone(uiState.value.searchText)
            }
        }

    }
}


