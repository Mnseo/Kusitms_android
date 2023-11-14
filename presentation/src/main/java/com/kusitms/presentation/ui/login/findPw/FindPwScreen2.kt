package com.kusitms.presentation.ui.login.findPw

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.navigation.NavRoutes


@Composable
fun FindPwScreen2(navController: NavHostController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {

    }
}

@Composable
fun FindPw