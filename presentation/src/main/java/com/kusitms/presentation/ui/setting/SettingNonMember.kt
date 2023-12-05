package com.kusitms.presentation.ui.setting


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.setting.getNonMemberSetting
import com.kusitms.presentation.model.setting.openUriSetting

@Composable
fun SettingNonMember(navController: NavHostController) {
    KusitmsScaffoldNonScroll(topbarText = stringResource(id = R.string.setting_topbar), navController = navController) {
        SettingNonMemberColumn1(navController = navController)
    }
}

@Composable
fun SettingNonMemberColumn1(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {
        Spacer(modifier = Modifier.height(73.5.dp))
        SettingNonMemberColumn2(navController = navController)
    }
}

@Composable
fun SettingNonMemberColumn2(navController: NavHostController) {
    val uriHandler = LocalUriHandler.current
    LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = KusitmsColorPalette.current.Grey900),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            items(getNonMemberSetting(navController)) { item->
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
fun SettingPreview() {
    SettingNonMember(navController = rememberNavController())
}