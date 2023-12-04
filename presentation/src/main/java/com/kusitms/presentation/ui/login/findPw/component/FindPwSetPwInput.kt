package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            //Error 1: 8자 이하 , Error2: 비밀번호 일치 x
            val isError1 = newPassword.length < 8
            val isError2 = newPassword.isNotBlank() && newPasswordConfirm.isNotBlank() && newPassword != newPasswordConfirm

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
                    onPwChange(it)
                },
                isError = isError1)
            Spacer(modifier = Modifier.height(4.dp))
            //Error1
            if(isError1) {
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
                value = pwValidation,
                onValueChange = {
                                onValidationChange(it)
                },
                isError = isError2
            )
            Spacer(modifier = Modifier.height(4.dp))
            //Error1
            if(isError1) {
                Text(
                    text = stringResource(id = R.string.find_pw_validation3),
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Sub2
                )
            }
        }
}

