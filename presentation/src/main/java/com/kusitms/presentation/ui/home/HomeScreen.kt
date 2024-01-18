package com.kusitms.presentation.ui.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Setting

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey900)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_logo),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Image(
                    painterResource(id = R.drawable.ic_bell),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { },
                    contentDescription = stringResource(id = R.string.home_ic_alarm)
                )
                Spacer(modifier = Modifier.width(24.dp))
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigate(NavRoutes.SettingMember.route)
                        },
                    imageVector = KusitmsIcons.Setting,
                    contentDescription = stringResource(R.string.home_ic_setting)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HomeProfile(profile = ProfileModel()) { }
        Spacer(modifier = Modifier.height(8.dp))
        HomeNoticeNone()
        Spacer(modifier = Modifier.height(8.dp))
        HomeCurriculumNone()
        HomeTeamExist()
    }
}


@Preview
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}