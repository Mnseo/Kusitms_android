package com.kusitms.presentation.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.setting.SettingStatus
import com.kusitms.presentation.model.setting.SettingViewModel
import com.kusitms.presentation.model.setting.getMemberSetting
import com.kusitms.presentation.model.setting.openUriSetting
import com.kusitms.presentation.navigation.NavRoutes

@Composable
fun SettingMember(
    navController: NavHostController,
    viewModel: SettingViewModel
) {
    val settingStatus by viewModel.settingStatus.collectAsState()

    LaunchedEffect(settingStatus) {
        when(settingStatus) {
            SettingStatus.LOGOUT, SettingStatus.SIGNOUT -> {
                navController.navigate(NavRoutes.LogInScreen.route) {
                    popUpTo(NavRoutes.SettingMember.route) { inclusive = true
                    }
                }

        }
            //처리.. 필요..
            SettingStatus.ERROR, SettingStatus.DEFAULT -> {}
        }
    }

    KusitmsScaffoldNonScroll(topbarText = stringResource(id = R.string.setting_topbar), navController = navController) {
        SettingMemberColumn1(navController = navController, viewModel)
    }
}

@Composable
fun SettingMemberColumn1(navController: NavHostController, viewModel: SettingViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {
        KusitmsMarginVerticalSpacer(size = 114)
        SettingToggle(title = "푸시알림", viewModel =  viewModel)
        SettingMemberColumn2(viewModel =  viewModel, navController = navController)
    }
}


@Composable
fun SettingMemberColumn2(viewModel: SettingViewModel, navController: NavHostController) {
    val uriHandler = LocalUriHandler.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        items(getMemberSetting(viewModel, navController)) { item->
            SettingTitle(
                title = item.title,
                onClick = {
                    if(item.url.isNotEmpty()) { openUriSetting(item.url, uriHandler) }
                    else item.onClick()
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewSettingMember() {
    val SettingViewModel:SettingViewModel = hiltViewModel()
    SettingMember(rememberNavController(), SettingViewModel)
}
