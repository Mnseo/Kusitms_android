package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable


@Composable
fun KusitmsInputField(
    text: String,
    onTextChanged: (String) -> Unit,
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChanged,
        decorationBox = {

        })
}