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
        .height(128.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        //id Input
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_id_caption),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        KusitmsInputField(text = R.string.login_member_id_placeholder, value = id, onValueChange = onIdChange)
        Spacer(modifier = Modifier.height(40.dp))

        //pw Input
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_pw_caption),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        KusitmsInputField(text = R.string.login_member_pw_placeholder, value = id, onValueChange = onIdChange)

    }
}