package com.kusitms.presentation.ui.signIn

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun KusitmsInputField(
    @StringRes text:Int,
    value:String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text= stringResource(text),
                    color= KusitmsColorPalette.current.Grey400,
                    style = KusitmsTypo.current.Text_Medium
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = KusitmsColorPalette.current.White,
                focusedBorderColor = KusitmsColorPalette.current.Main500,
                unfocusedBorderColor = KusitmsColorPalette.current.Grey700,
                unfocusedLabelColor = KusitmsColorPalette.current.Grey400,
                focusedLabelColor = KusitmsColorPalette.current.White,
                backgroundColor = KusitmsColorPalette.current.Grey700
            ),
            shape = RoundedCornerShape(16.dp),
            maxLines = 1
        )
    }