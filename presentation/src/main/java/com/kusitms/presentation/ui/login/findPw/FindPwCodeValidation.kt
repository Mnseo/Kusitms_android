package com.kusitms.presentation.ui.login.findPw

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.model.signIn.InputState
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.login.findPw.component.FindPwEmailComval
import com.kusitms.presentation.ui.signIn.KusitmsInputField


@Composable
fun FindPwCodeValidation(
    navController: NavHostController,
    viewModel: FindPwViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.resetState()
        viewModel.startCountDown(5*60)
    }
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        FindPw2Column(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun FindPw2Column(viewModel: FindPwViewModel, navController: NavHostController) {
    val Error by viewModel.inputState.collectAsState()

    // 이메일 상태가 VALID로 변경되었을 때의 동작 정의
    LaunchedEffect(key1 = Error) {
        if (Error == InputState.VALID) {
            navController.navigate(NavRoutes.FindPwSetNewPw.createRoute(false))
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(176.5.dp))
        FindPwEmailComval(text = R.string.find_pw_caption_email, viewModel = viewModel)
        KusitmsMarginVerticalSpacer(size = 24)
        Text(text = stringResource(id = R.string.find_pw_caption4), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        KusitmsMarginVerticalSpacer(size = 4)
        FindPw2GetCode(viewModel = viewModel)
        KusitmsMarginVerticalSpacer(size = 4)
        if(Error == InputState.INVALID) {
            Text(
                text = stringResource(id = R.string.find_pw_validation_warning),
                style= KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Sub2
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        FindPwCodeBtn(
            viewModel = viewModel,
            onNextClick = { viewModel.validateCode() }
        )
        KusitmsMarginVerticalSpacer(size = 24)
    }
}


@Composable
fun FindPw2GetCode(viewModel: FindPwViewModel) {
    val code by viewModel.code.collectAsState()
    val timeLeft by viewModel.timeLeft.collectAsState()
    val Error by viewModel.inputState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        KusitmsInputField(
            text = R.string.find_pw_placeholder4,
            value = code,
            onValueChange = { viewModel.updateCode(it) },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart),
            isError = (Error == InputState.INVALID)
        )
        Text(
            text = formatTime(timeLeft),
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.White,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 56.dp)
        )
    }
}

@Composable
fun FindPwCodeBtn(viewModel: FindPwViewModel, onNextClick: () -> Unit) {
    val codeInputState = viewModel.inputState.collectAsState()
    val isTimerFinished = viewModel.isTimerFinished.collectAsState()

    val buttonColor = if (!isTimerFinished.value) {
        when (codeInputState.value) {
            InputState.DEFAULT -> KusitmsColorPalette.current.Grey500
            InputState.ENTERED -> KusitmsColorPalette.current.Grey100
            InputState.INVALID -> KusitmsColorPalette.current.Grey500
            InputState.VALID -> KusitmsColorPalette.current.Main500
        }
    } else {
        KusitmsColorPalette.current.Grey500
    }

    val textColor = if (!isTimerFinished.value) {
        when (codeInputState.value) {
            InputState.DEFAULT -> KusitmsColorPalette.current.Grey400
            InputState.ENTERED -> KusitmsColorPalette.current.Grey600
            InputState.INVALID -> KusitmsColorPalette.current.Grey400
            InputState.VALID -> KusitmsColorPalette.current.White
        }
    } else {
        KusitmsColorPalette.current.Grey400
    }

    Button(
        modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        enabled = !isTimerFinished.value,
        onClick = { onNextClick() },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.find_pw_btn2),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = textColor
        )
    }
}

fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d", minutes, remainingSeconds)
}



