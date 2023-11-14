package com.kusitms.presentation.ui.signIn

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.xIcon
import com.kusitms.presentation.R

@Composable
fun KusitmsInputField(
    @StringRes text:Int,
    value:String,
    onValueChange: (String) -> Unit,
    isError:Boolean = false
) {
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
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = KusitmsColorPalette.current.White,
                focusedBorderColor = KusitmsColorPalette.current.Main500,
                unfocusedBorderColor = if(isError) KusitmsColorPalette.current.Sub2 else KusitmsColorPalette.current.Grey700,
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
                            contentDescription = "Clear Text"
                        )

                    }
                }
                if(isError && !isFocused) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_finpw_warning),
                            contentDescription = "warning")

                    }
                }
            }

        )
    }

@Preview
@Composable
fun previewInput() {
    var example by remember { mutableStateOf("example") }
    KusitmsInputField(
        text = R.string.find_pw_placeholder1,
        value = example,
        onValueChange = { newValue -> example = newValue }
    )
}