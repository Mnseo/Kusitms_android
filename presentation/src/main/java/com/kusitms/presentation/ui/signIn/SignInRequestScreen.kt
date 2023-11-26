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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInRequestModel
import com.kusitms.presentation.navigation.NavRoutes


@Composable
fun SignInRequestScreen(viewModel: SignInRequestModel, navController: NavHostController) {
    KusitmsScaffoldNonScroll(topbarText = stringResource(id = R.string.signin_request_topbar), navController = navController) {
        SignInRequestColumn(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun SignInRequestColumn(viewModel: SignInRequestModel, navController: NavHostController) {
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
fun SignInRequestSubColumn1(viewModel: SignInRequestModel, navController: NavHostController) {
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
        SignInRequestBtn(viewModel = viewModel, onNextClick = { viewModel.validateEmail()
                if(viewModel.emailInputState.value == SignInRequestModel.EmailInputState.VALID) { navController.navigate(NavRoutes.LogInScreen.route)}
            }
        )
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun SignInRequestSubColumn2(viewModel: SignInRequestModel) {
    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp),
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
        androidx.compose.material3.Text(
            text = stringResource(id = R.string.signin_request_warning1),
            style = KusitmsTypo.current.Text_Medium,
            color = if(viewModel.emailInputState.value == SignInRequestModel.EmailInputState.INVALID) {
                KusitmsColorPalette.current.Sub2
            } else Color.Transparent
        )
    }
}

@Composable
fun SignInRequestBtn(viewModel: SignInRequestModel, onNextClick: () -> Unit) {
    val emailInputState = viewModel.emailInputState.collectAsState()
    val buttonColor = when (emailInputState.value) {
        SignInRequestModel.EmailInputState.DEFAULT -> KusitmsColorPalette.current.Grey500
        SignInRequestModel.EmailInputState.ENTERED -> KusitmsColorPalette.current.Main500
        SignInRequestModel.EmailInputState.INVALID -> KusitmsColorPalette.current.Grey500
        SignInRequestModel.EmailInputState.VALID -> KusitmsColorPalette.current.Main500
    }
    val textColor = when(emailInputState.value) {
        SignInRequestModel.EmailInputState.DEFAULT -> KusitmsColorPalette.current.Grey400
        SignInRequestModel.EmailInputState.ENTERED -> KusitmsColorPalette.current.White
        SignInRequestModel.EmailInputState.INVALID -> KusitmsColorPalette.current.Grey400
        SignInRequestModel.EmailInputState.VALID -> KusitmsColorPalette.current.White
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
