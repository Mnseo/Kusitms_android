package com.kusitms.presentation.ui.login.findPw

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.LoginStatus
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.model.signIn.InputState
import com.kusitms.presentation.navigation.NavRoutes


@Composable
fun FindPwCheckEmail(
    navController:NavHostController,
    viewModel: FindPwViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.resetState()
    }
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        FindPw1Column(
            viewModel = viewModel,
            navController = navController
        )
    }
}

@Composable
fun FindPw1Column(viewModel: FindPwViewModel, navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
            horizontalAlignment =  Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(148.dp))
            FindPwEmailInput(viewModel = viewModel)
            Spacer(modifier = Modifier.weight(1f))
            FindPwBtn(R.string.find_pw_btn1, viewModel = viewModel, navController = navController)
            Spacer(modifier = Modifier.height(24.dp))
        }
}


@Composable
fun FindPwBtn(@StringRes text: Int, viewModel: FindPwViewModel, navController: NavHostController) {
    val emailInputState = viewModel.inputState.collectAsState()

    // 버튼 색상 및 텍스트 색상 결정
    val buttonColor = getButtonColor(inputState = emailInputState.value)
    val textColor = getTextColor(inputState = emailInputState.value)

    // 이메일 상태가 VALID로 변경되었을 때의 동작 정의
    LaunchedEffect(key1 = emailInputState.value) {
        if (emailInputState.value == InputState.VALID) {
            navController.navigate(NavRoutes.FindPwCodeValidation.route)
        }
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = {
            viewModel.validateEmail()
        },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(size = 16.dp)
    ) {
        Text(
            text = stringResource(id = text),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = textColor,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}


@Composable
fun getButtonColor(inputState: InputState): Color {
    return when (inputState) {
        InputState.DEFAULT, InputState.INVALID -> KusitmsColorPalette.current.Grey500
        InputState.ENTERED, InputState.VALID -> KusitmsColorPalette.current.Main500
    }
}

@Composable
fun getTextColor(inputState: InputState): Color {
    return when (inputState) {
        InputState.DEFAULT, InputState.INVALID -> KusitmsColorPalette.current.Grey400
        InputState.ENTERED, InputState.VALID -> KusitmsColorPalette.current.White
    }
}
