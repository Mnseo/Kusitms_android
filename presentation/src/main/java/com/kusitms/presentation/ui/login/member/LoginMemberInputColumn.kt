package com.kusitms.presentation.ui.login.member

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.signIn.KusitmsInputField

@Composable
fun LoginMemberInputColumn(
    id:String,
    pw:String,
    onIdChange: (String) -> Unit,
    onPwChange: (String) -> Unit
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
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
        KusitmsInputField(text = R.string.login_member_id_placeholder, value = id, onValueChange = onIdChange)
        Spacer(modifier = Modifier.height(24.dp))

        //pw Input
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_pw_caption),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        LoginMemberPwInput(text = R.string.login_member_pw_placeholder, value = pw, onValueChange = onPwChange)
        Spacer(modifier = Modifier.height(24.dp))

        //id- pw검증
        if(id != "example" || pw != "example") {
            Text(
                text = stringResource(id = R.string.login_id_validation),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }

    }
}