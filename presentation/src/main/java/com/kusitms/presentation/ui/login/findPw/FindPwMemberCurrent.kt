package com.kusitms.presentation.ui.login.findPw


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.signIn.KusitmsInputField

@Composable
fun FindPwMemberCurrent(viewModel: FindPwViewModel, navController: NavHostController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        FindPwMemberColumn(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun FindPwMemberColumn(viewModel: FindPwViewModel, navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        KusitmsMarginVerticalSpacer(size = 204)
        FindPwMemberCurrentInput(viewModel = viewModel)
        Spacer(modifier = Modifier.weight(1f))
        MemberCurrentButton(viewModel, navController)
        KusitmsMarginVerticalSpacer(size = 24)
    }

}

@Composable
fun FindPwMemberCurrentInput(viewModel: FindPwViewModel) {
    val currentPassword by viewModel.password.collectAsState()
    val passwordError by viewModel.passwordErrorState.collectAsState()
    Text(
        text = stringResource(id = R.string.find_pw_caption1),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
    Spacer(modifier = Modifier.height(4.dp))
    KusitmsInputField(
        text = R.string.find_pw_placeholder1,
        value = currentPassword,
        onValueChange = {
            viewModel.updatePassword(it)
        },
        isError = passwordError == FindPwViewModel.PasswordErrorState.NotCurrentPw
    )
    Spacer(modifier = Modifier.height(4.dp))
    //Error1
    if(passwordError == FindPwViewModel.PasswordErrorState.ShortPassword) {
        Text(
            text = stringResource(id = R.string.find_pw_validation1),
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Sub2
        )
    }
}

@Composable
fun MemberCurrentButton(viewModel: FindPwViewModel, navController: NavHostController) {
    val passwordErrorState = viewModel.passwordErrorState.collectAsState()
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
            if (passwordErrorState.value == FindPwViewModel.PasswordErrorState.Pass) {
                navController.navigate(NavRoutes.FindPwSetNewPw.route)
            }
        },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.find_pw_btn4),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = textColor
        )
    }
}
