package com.kusitms.presentation.ui.profile

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.PartList
import com.kusitms.presentation.model.profile.ProfileViewModel
import com.kusitms.presentation.model.profile.categories
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Search


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val expanded by viewModel.expended.collectAsState()
    val profileList by viewModel.profileList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {
        KusitsmTopBarTextWithIcon(
            text = stringResource(id = R.string.profile_topbar),
            iconContent = {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigate(NavRoutes.ProfileSearch.route)
                        },
                    imageVector = KusitmsIcons.Search,
                    contentDescription = "검색"
                )
            },

        )
        KusitmsMarginVerticalSpacer(size = 32)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    viewModel.toggleExpanded()
                },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey700,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            PartListButton(
                expanded = expanded,
                viewModel
            )

            if (expanded) {
                AllPartList(
                    partNameList = categories,
                    viewModel = viewModel
                )
            }
        }
        ProfileListScreen(
            navController = navController,
            profileList = profileList
        )
    }
}

@Composable
private fun PartListButton(
    expanded: Boolean,
    viewModel: ProfileViewModel,
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
            text = uiState.currentSelectedPart.takeIf { it.isNotEmpty() }
                ?: stringResource(id = R.string.profile_part_toggle),
            style = KusitmsTypo.current.Text_Medium,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = KusitmsColorPalette.current.Grey100,
        )
        Icon(
            imageVector = KusitmsIcons.ArrowDown,
            contentDescription = stringResource(id = R.string.profile_part_toggle),
            tint = KusitmsColorPalette.current.Grey400,
            modifier = Modifier
                .rotate(if (expanded) 180f else 0f)
                .padding(horizontal = 16.dp)
        )

    }

}

@Composable
fun AllPartList(
    partNameList: List<PartList>,
    viewModel: ProfileViewModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        partNameList.forEach { part ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .clickable {
                        viewModel.changeSelectPart(part.name)

                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = part.name,
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Grey400,
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}