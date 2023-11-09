package com.kusitms.presentation.ui.login.findPw

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.signIn.KusitmsInputField

@Composable
fun InputFieldWithValidation(
    inputLabelString: Int,
    inputValue: String,
    @StringRes inputHint: Int,
    onInputChange: (String)-> Unit,
    validationCheck: (String) -> Boolean,
    validationMessage: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Input Label
        Text(
            text = stringResource(id = inputLabelString),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.height(4.dp))
        // Input Field
        KusitmsInputField(text = inputHint, value = inputValue, onValueChange = onInputChange)
        Spacer(modifier = Modifier.height(24.dp))

        // Validation
        if (!validationCheck(inputValue)) {
            Text(
                text = stringResource(id = validationMessage),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Sub2
            )
        }
    }
}