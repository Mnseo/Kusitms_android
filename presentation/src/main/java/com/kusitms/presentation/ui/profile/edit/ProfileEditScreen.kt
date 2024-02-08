package com.kusitms.presentation.ui.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.model.profile.edit.ProfileFilterList
import com.kusitms.presentation.model.profile.edit.categories
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ProfileEditScreen(
    viewModel: ProfileEditViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val scrollState = rememberScrollState()

    val expanded by viewModel.expended.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsState()

    Column {
        KusitsmTopBarBackTextWithIcon(
            text = stringResource(id = R.string.profile_edit_toolbar),
            onBackClick = {
                onBack()
            },
        ) {
            Text(
                text = stringResource(id = R.string.profile_edit_modify),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Main400,
                modifier = Modifier.clickable {

                }
            )
        }
        KusitmsMarginVerticalSpacer(size = 32)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    viewModel.toggleExpanded()
                },
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey700,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            ProfileFilterButton(
                expanded = expanded,
                viewModel = viewModel
            )
            if (expanded) {
                AllProfileFilterList(
                    partNameList = categories,
                    viewModel = viewModel
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(KusitmsColorPalette.current.Grey900)
                .verticalScroll(scrollState)
                .height(910.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            if (uiState.currentSelectedProfileFilter == "기본 프로필") {
                ProfileBasic(viewModel)
            } else {
                ProfileAdd(viewModel)
            }
        }
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
private fun ProfileFilterButton(
    expanded: Boolean,
    viewModel: ProfileEditViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()


    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = uiState.currentSelectedProfileFilter.takeIf { it.isNotEmpty() }
                ?: stringResource(id = R.string.profile_edit_basic),
            style = KusitmsTypo.current.Text_Medium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            color = KusitmsColorPalette.current.Grey100,
        )
        Icon(
            imageVector = KusitmsIcons.ArrowDown,
            contentDescription = stringResource(id = R.string.profile_edit_filter),
            tint = KusitmsColorPalette.current.Grey400,
            modifier = Modifier
                .rotate(if (expanded) 180f else 0f)
                .padding(horizontal = 16.dp)
        )
    }
}


@Composable
fun AllProfileFilterList(
    partNameList: List<ProfileFilterList>,
    viewModel: ProfileEditViewModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        partNameList.forEach { profile ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .clickable {
                        viewModel.changeSelectProfileFilter(profile.name)

                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = profile.name,
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Grey400,
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileEditScreenPreview() {
    ProfileEditScreen(
        onBack = {}
    )
}
