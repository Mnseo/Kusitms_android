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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
fun FindPwCodeValidation(viewModel: FindPwViewModel, navController: NavHostController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        FindPw2Column(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun FindPw2Column(viewModel: FindPwViewModel, navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(176.5.dp))
        FindPwEmailComval(text = R.string.find_pw_caption_email, validStr = FindPwViewModel().email.toString())
        KusitmsMarginVerticalSpacer(size = 24)
        Text(text = stringResource(id = R.string.find_pw_caption4), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        KusitmsMarginVerticalSpacer(size = 4)
        FindPw2GetCode(viewModel = viewModel)
        KusitmsMarginVerticalSpacer(size = 4)
        if(viewModel.inputState.value == InputState.INVALID) {
            Text(
                text = stringResource(id = R.string.find_pw_validation_warning),
                style= KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Sub2
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        FindPwCodeBtn(
            viewModel = viewModel,
            onNextClick = { viewModel.validateCode()
                if (viewModel.inputState.value == InputState.VALID) {
                    navController.navigate(NavRoutes.FindPwSetNewPw.route)
                }
            }
        )
        KusitmsMarginVerticalSpacer(size = 24)
    }
}


@Composable
fun FindPw2GetCode(viewModel: FindPwViewModel) {
    val code by viewModel.code.collectAsState()
    val timeLeft by viewModel.timeLeft.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.startCountDown(5*60)
    }
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
                .align(Alignment.CenterStart)
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
    val buttonColor = when (codeInputState.value) {
        InputState.DEFAULT -> KusitmsColorPalette.current.Grey500
        InputState.ENTERED -> KusitmsColorPalette.current.Grey100
        InputState.INVALID -> KusitmsColorPalette.current.Grey500
        InputState.VALID -> KusitmsColorPalette.current.Main500
    }
    val textColor = when(codeInputState.value) {
        InputState.DEFAULT -> KusitmsColorPalette.current.Grey400
        InputState.ENTERED -> KusitmsColorPalette.current.Grey600
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


@Preview
@Composable
fun previewSetNewPw() {
    FindPwCodeValidation(FindPwViewModel(),rememberNavController())
}

