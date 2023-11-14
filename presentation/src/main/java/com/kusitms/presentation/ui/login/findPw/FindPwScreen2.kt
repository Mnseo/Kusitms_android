package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.login.findPw.component.FindPw2CodeInput
import com.kusitms.presentation.ui.login.findPw.component.FindPwEmailComval
import com.kusitms.presentation.ui.signIn.KusitmsInputField


@Composable
fun FindPwScreen2(navController: NavHostController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {

    }
}

@Composable
fun FindPw2Column() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(176.5.dp))
        FindPwEmailComval(text = R.string.find_pw_caption_email, validStr = FindPwViewModel().email.toString())
        Spacer(modifier = Modifier.height(24.dp))

    }
}

