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
import com.kusitms.presentation.ui.signIn.KusitmsInputField

@Composable
fun FindPwPwInput(
    pw:String,
    onPwChange: (String) -> Unit,
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        val isError = pw!="example"
        //id Input
        Text(
            text= stringResource(id = R.string.find_pw_caption1),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        KusitmsInputField(text = R.string.login_manager_id_placeholder, value = pw, onValueChange = onPwChange, isError = isError)
        Spacer(modifier = Modifier.height(24.dp))

        //id 검증
        if(isError) {
            Text(
                text = stringResource(id = R.string.find_pw_validation1),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }

    }
}

@Preview
@Composable
fun PreviewPw() {
    var example by remember { mutableStateOf("examples") }
    FindPwPwInput(pw = example, onPwChange = {newValue->example =example} )
}