package com.kusitms.presentation.ui.login.member

import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.xIcon
import com.kusitms.presentation.R

@Composable
fun LoginMemberPwInput(
    @StringRes text:Int,
    value:String,
    onValueChange: (String) -> Unit
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        interactionSource = interactionSource,
        placeholder = {
            Text(
                text= stringResource(text),
                color= KusitmsColorPalette.current.Grey400,
                style = KusitmsTypo.current.Text_Medium
            )
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = KusitmsColorPalette.current.White,
            focusedBorderColor = KusitmsColorPalette.current.Main500,
            unfocusedBorderColor = KusitmsColorPalette.current.Grey700,
            unfocusedLabelColor = KusitmsColorPalette.current.Grey400,
            focusedLabelColor = KusitmsColorPalette.current.White,
            backgroundColor = KusitmsColorPalette.current.Grey700
        ),
        shape = RoundedCornerShape(16.dp),
        maxLines = 1,
        trailingIcon = {
            if(isFocused && value.isNotEmpty()) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = xIcon.vector,
                        contentDescription = "Clear Text",
                        tint = Color.Unspecified
                    )

                }
            }
            else if(!isFocused) {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = "Clear Text",
                        tint = Color.Unspecified
                    )

                }
            }
        }

    )
}
