package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.model.signIn.InputState
import com.kusitms.presentation.navigation.NavRoutes

@Composable
fun FindPwSetNewPw(
    navController: NavHostController,
    viewModel: FindPwViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.resetState()
    }
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        SetNewPwColumn(viewModel =  viewModel, navController)
    }
}

@Composable
fun SetNewPwColumn(viewModel: FindPwViewModel, navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        KusitmsMarginVerticalSpacer(size = 204)
        FindPwSetPwInput(viewModel = viewModel)
        Spacer(modifier = Modifier.weight(1f))
        SetNewPwButton(viewModel = viewModel, navController = navController)
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun SetNewPwButton(viewModel: FindPwViewModel, navController: NavHostController) {
    val passwordErrorState = viewModel.passwordErrorState.collectAsState()
    val inputState = viewModel.inputState.collectAsState()
    val isInitialState = viewModel.newPw.value.isEmpty() && viewModel.newPwConfirm.value.isEmpty()

    val buttonColor = when {
        isInitialState -> KusitmsColorPalette.current.Grey500
        passwordErrorState.value == FindPwViewModel.PasswordErrorState.None -> KusitmsColorPalette.current.Main500
        else -> KusitmsColorPalette.current.Grey500
    }
    val textColor = when {
        isInitialState -> KusitmsColorPalette.current.Grey400
        passwordErrorState.value == FindPwViewModel.PasswordErrorState.None -> KusitmsColorPalette.current.White
        else -> KusitmsColorPalette.current.Grey400
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = {
            if (passwordErrorState.value == FindPwViewModel.PasswordErrorState.None && inputState.value == InputState.VALID) {
                navController.navigate(NavRoutes.LogInScreen.route)
            }
        },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.find_pw_btn3),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = textColor
        )
    }
}

