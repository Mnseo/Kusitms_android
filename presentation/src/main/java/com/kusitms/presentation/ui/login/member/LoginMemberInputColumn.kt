package com.kusitms.presentation.ui.login.member

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.LoginStatus
import com.kusitms.presentation.model.login.LoginViewModel
import com.kusitms.presentation.ui.signIn.KusitmsInputField

@Composable
fun LoginMemberInputColumn(
   viewModel: LoginViewModel
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val Error by viewModel.loginStatus.collectAsState()

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        //id Input
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_id_caption),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        KusitmsInputField(
            text = R.string.login_member_id_placeholder,
            value = email,
            onValueChange = {viewModel.updateEmail(it)}
        )
        Spacer(modifier = Modifier.height(24.dp))

        //pw Input
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_pw_caption),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        LoginMemberPwInput(
            text = R.string.login_member_pw_placeholder,
            value = password,
            onValueChange = {viewModel.updatePassword(it)},
        )
        Spacer(modifier = Modifier.height(24.dp))

        if(Error == LoginStatus.ERROR) {
            Text(
                text = stringResource(id = R.string.login_id_validation),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }

    }
}