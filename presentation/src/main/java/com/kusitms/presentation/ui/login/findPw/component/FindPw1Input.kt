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
fun FindPwEmailInput(
    viewModel: FindPwViewModel
) {
    val email by viewModel.email.collectAsState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        //id Input
        Text(
            text= stringResource(id = R.string.find_pw_caption_email),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        KusitmsInputField(
            text = R.string.find_pw_placeholder_email,
            value = email,
            onValueChange = viewModel::updateEmail,
            isError = !viewModel.isEmailValid
        )
        Spacer(modifier = Modifier.height(24.dp))

        //id 검증
        if(!viewModel.isEmailValid) {
            Text(
                text = stringResource(id = R.string.find_pw_validation_email),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }

    }
}
