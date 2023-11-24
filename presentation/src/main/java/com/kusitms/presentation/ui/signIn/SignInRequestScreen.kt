package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInRequestModel
import com.kusitms.presentation.ui.login.manager.LoginManagerInputColumn
import com.kusitms.presentation.ui.login.member.LoginMemberPwInput


@Composable
fun SignInRequestScreen(viewModel: SignInRequestModel, navController: NavHostController) {
    KusitmsScaffoldNonScroll(topbarText = stringResource(id = R.string.signin_request_topbar), navController = navController) {
        SignInRequestColumn(viewModel = viewModel)
    }
}

@Composable
fun SignInRequestColumn(viewModel: SignInRequestModel) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KusitmsMarginVerticalSpacer(size = 120)
        SignInRequestSubColumn1(viewModel = viewModel)

    }

}

@Composable
fun SignInRequestSubColumn1(viewModel: SignInRequestModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(450.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = stringResource(id = R.string.signin_request_title), style= KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        Spacer(modifier = Modifier.height(72.dp))
        SignInRequestSubColumn2(viewModel = viewModel)
    }
}

@Composable
fun SignInRequestSubColumn2(viewModel: SignInRequestModel) {
    val email = viewModel.email.collectAsState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.signin_request_caption1),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        KusitmsInputField(text = R.string.signin_request_placeholder1, value = email.value, onValueChange = {viewModel.updateEmail(it)})
        Spacer(modifier = Modifier.height(24.dp))

        androidx.compose.material3.Text(
            text= stringResource(id = R.string.signin_request_caption2),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        KusitmsInputField(text = R.string.signin_request_placeholder2)
        Spacer(modifier = Modifier.height(24.dp))
}


@Composable
fun SigInRequestBtn(viewModel: SignInRequestModel) {
    val buttonColor = if(viewModel.isEmailValid) {

    }
}

}



