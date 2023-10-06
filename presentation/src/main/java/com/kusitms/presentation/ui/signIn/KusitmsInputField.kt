package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun LinkCheckRowExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LinkCheckBox()
        LinkTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkTextField() {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    var isClicked by remember { mutableStateOf(false)}
    var borderColor by remember { mutableStateOf(KusitmsColorPalette.current.White) }
    Row(
        modifier = Modifier
            .width(167.dp)
            .fillMaxHeight()
            .border(
                width = 1.dp,
                color = KusitmsColorPalette.current.White,
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = KusitmsColorPalette.current.Grey700)
            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(99.dp)
                .height(48.dp)
                .background(KusitmsColorPalette.current.Grey700)
                .border(width = 1.dp, color = borderColor, shape=RoundedCornerShape(12.dp))
                .clickable {
                    isClicked = !isClicked
                    borderColor = if(isClicked) {
                        KusitmsColorPalette.current.Main500
                    } else {
                        KusitmsColorPalette.current.White
                    }
                }
        ) {
            TextField(
                value = textState.value,
                onValueChange = {
                    run { textState.value = it }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = KusitmsColorPalette.current.Main500,
                    disabledLabelColor = Color.Unspecified,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {Text(stringResource(id = R.string.signin2_placeholder1), style = KusitmsTypo.current.Text_Medium, color = KusitmsColorPalette.current.White )}
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_inputx),
            contentDescription = null, contentScale = ContentScale.None,
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .padding(1.dp)
                .clickable { textState.value = TextFieldValue("") } )

    }
}


@Preview
@Composable
fun exampleRow() {
    LinkCheckRowExample()
}