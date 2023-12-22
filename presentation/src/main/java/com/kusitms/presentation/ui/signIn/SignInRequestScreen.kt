package com.kusitms.presentation.ui.signIn


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
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
import com.kusitms.presentation.model.signIn.InputState
import com.kusitms.presentation.model.signIn.SignInRequestViewModel
import com.kusitms.presentation.navigation.NavRoutes


@Composable
fun SignInRequestScreen(viewModel: SignInRequestViewModel, navController: NavHostController) {
    DisposableEffect(key1 = Unit) {
        onDispose {
            viewModel.resetState()
        }
    }
    KusitmsScaffoldNonScroll(topbarText = stringResource(id = R.string.signin_request_topbar), navController = navController) {
        SignInRequestColumn(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun SignInRequestColumn(viewModel: SignInRequestViewModel, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey900),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KusitmsMarginVerticalSpacer(size = 120)
        SignInRequestSubColumn1(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun SignInRequestSubColumn1(viewModel: SignInRequestViewModel, navController: NavHostController) {
    val canNavigateToNextScreen by viewModel.canNavigateToNextScreen.collectAsState()
    LaunchedEffect(canNavigateToNextScreen) {
        if (canNavigateToNextScreen) {
            navController.navigate(NavRoutes.LogInScreen.route)
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = stringResource(id = R.string.signin_request_title), style= KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        KusitmsMarginVerticalSpacer(size = 72)
        SignInRequestSubColumn2(viewModel = viewModel)
        Spacer(modifier = Modifier.weight(1f))
        SignInRequestBtn(viewModel = viewModel, onNextClick = { viewModel.signInRequestCheck() }
        )
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun SignInRequestSubColumn2(viewModel: SignInRequestViewModel) {
    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()
    val signInResult = viewModel.signInResult.collectAsState()

    val message = when (signInResult.value) {
        "REGISTERED" -> stringResource(id = R.string.signin_request_warning2)
        "NO_ACCOUNT" -> stringResource(id = R.string.signin_request_warning1)
        else -> ""
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(280.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        androidx.compose.material3.Text(
            text = stringResource(id = R.string.signin_request_caption1),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        KusitmsMarginVerticalSpacer(size = 4)
        KusitmsInputField(
            text = R.string.signin_request_placeholder1,
            value = email.value,
            onValueChange = { viewModel.updateEmail(it) })
        KusitmsMarginVerticalSpacer(size = 24)

        androidx.compose.material3.Text(
            text = stringResource(id = R.string.signin_request_caption2),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        KusitmsMarginVerticalSpacer(size = 4)
        KusitmsInputField(
            text = R.string.signin_request_placeholder2,
            value = password.value,
            onValueChange = {viewModel.updatePassword(it)})
        KusitmsMarginVerticalSpacer(size = 24)
        if (message.isNotEmpty()) {
            androidx.compose.material3.Text(
                text = message,
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }
    }
}

@Composable
fun SignInRequestBtn(viewModel: SignInRequestViewModel, onNextClick: () -> Unit) {
    val emailInputState = viewModel.inputState.collectAsState()
    val buttonColor = when (emailInputState.value) {
        InputState.DEFAULT -> KusitmsColorPalette.current.Grey500
        InputState.ENTERED -> KusitmsColorPalette.current.Main500
        InputState.INVALID -> KusitmsColorPalette.current.Grey500
        InputState.VALID -> KusitmsColorPalette.current.Main500
    }
    val textColor = when(emailInputState.value) {
        InputState.DEFAULT -> KusitmsColorPalette.current.Grey400
        InputState.ENTERED -> KusitmsColorPalette.current.White
        InputState.INVALID -> KusitmsColorPalette.current.Grey400
        InputState.VALID -> KusitmsColorPalette.current.White
    }
    Button(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        onClick = { onNextClick() },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(16.dp)
        ) {
        androidx.compose.material3.Text(
            text = stringResource(id = R.string.signin_request_btn),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = textColor
        )
    }
}
