package com.kusitms.presentation.ui.profile.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.xIcon


@Composable
fun ProfileSearchField(
    text: String,
    onTextChange: (String) -> Unit,
    onClearClick: () -> Unit,
    submit: () -> Unit = {}
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChange,
        textStyle = KusitmsTypo.current.Text_Medium.copy(color = KusitmsColorPalette.current.Grey100),
        cursorBrush = SolidColor(KusitmsColorPalette.current.Main500),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onDone = {
            submit()
            Log.d("검색", "엔터")
        }),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = KusitmsColorPalette.current.Grey600,
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Spacer(modifier = Modifier.width(16.dp))
                    Box {
                        if (text.isEmpty()) {
                            Text(
                                text = "이름, 학교, 학과, 관심 분야",
                                style = KusitmsTypo.current.Text_Medium,
                                color = KusitmsColorPalette.current.Grey400
                            )
                        }
                        innerTextField.invoke()
                    }
                }

                IconButton(onClick = onClearClick) {
                    Icon(
                        imageVector = xIcon.vector,
                        contentDescription = "Clear Text",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun ProfileSearchFieldPreview() {
    ProfileSearchField(
        text = "",
        onTextChange = {},
        onClearClick = {}
    )
}