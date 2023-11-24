package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInRequestModel


@Composable
fun SignInRequestScreen(navController: NavHostController) {
    KusitmsScaffoldNonScroll(topbarText = stringResource(id = R.string.signin_request_topbar), navController = navController) {
        
    }
}

@Composable
fun SignInRequestColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KusitmsMarginVerticalSpacer(size = 120)
        Text(text = stringResource(id = R.string.signin_request_title), style= KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)

    }

}

@Composable
fun SignInRequestSubColumn() {

}


@Composable
fun SigInRequestBtn() {

}



