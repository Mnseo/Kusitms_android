package com.kusitms.presentation.ui.profile

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.PartList
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Search


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
) {
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
                        .clickable { },
                    imageVector = KusitmsIcons.Search,
                    contentDescription = "검색"
                )
            })
        KusitmsMarginVerticalSpacer(size = 32)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey700,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            var expanded by remember {
                mutableStateOf(false)
            }

            Row(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.profile_part_toggle),
                    style = KusitmsTypo.current.Text_Medium,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = KusitmsColorPalette.current.Grey100,
                )

                PartListButton(expanded = expanded, onClick = { /*TODO*/ })
            }
            AllPartList(partName = 0)
        }
        ProfileListScreen()
    }
}

@Composable
private fun PartListButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick, modifier = modifier.padding(horizontal = 8.dp)) {
        Icon(
            imageVector = KusitmsIcons.ArrowDown,
            contentDescription = stringResource(id = R.string.profile_part_toggle),
            tint = KusitmsColorPalette.current.Grey400
        )
    }
}

@Composable
fun AllPartList(
    @StringRes partName: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(partName),
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Grey400
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
    )
}