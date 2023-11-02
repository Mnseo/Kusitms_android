package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
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
fun FindPwEmailInput(
    id:String,
    onIdChange: (String) -> Unit,
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        //id Input
        Text(
            text= stringResource(id = R.string.find_pw_caption1),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        KusitmsInputField(text = R.string.login_manager_id_placeholder, value = id, onValueChange = onIdChange)
        Spacer(modifier = Modifier.height(24.dp))

        //id 검증
        if(id != "example") {
            Text(
                text = stringResource(id = R.string.find_pw_validation1),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }

    }
}