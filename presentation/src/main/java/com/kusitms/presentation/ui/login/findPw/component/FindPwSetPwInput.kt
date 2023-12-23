package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.ui.signIn.KusitmsInputField


@Composable
fun FindPwSetPwInput(viewModel:FindPwViewModel) {
    val newPassword by viewModel.newPw.collectAsState()
    val newPasswordConfirm by viewModel.newPwConfirm.collectAsState()
    val passwordError by viewModel.passwordErrorState.collectAsState(initial = FindPwViewModel.PasswordErrorState.None)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            //pwInput1
            Text(
                text = stringResource(id = R.string.find_pw_caption2),
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
            Spacer(modifier = Modifier.height(4.dp))
            KusitmsInputField(
                text = R.string.find_pw_placeholder2,
                value = newPassword,
                onValueChange = {
                    viewModel.updateNewPassword(it)
                    viewModel.validateNewPassword()
                },
                isError = passwordError == FindPwViewModel.PasswordErrorState.ShortPassword
            )
            Spacer(modifier = Modifier.height(4.dp))
            //Error1
            if(passwordError == FindPwViewModel.PasswordErrorState.ShortPassword) {
                Text(
                    text = stringResource(id = R.string.find_pw_validation2),
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Sub2
                )
            }

            //pwInput2
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.find_pw_caption3),
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey400
            )
            Spacer(modifier = Modifier.height(4.dp))
            KusitmsInputField(
                text = R.string.find_pw_placeholder3,
                value = newPasswordConfirm,
                onValueChange = {
                    viewModel.updateNewPasswordConfirm(it)
                    viewModel.validateNewPassword()
                },
                isError = passwordError == FindPwViewModel.PasswordErrorState.PasswordsDoNotMatch
            )
            Spacer(modifier = Modifier.height(4.dp))
            //Error2
            if(passwordError == FindPwViewModel.PasswordErrorState.PasswordsDoNotMatch) {
                Text(
                    text = stringResource(id = R.string.find_pw_validation3),
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Sub2
                )
            }
        }
}

