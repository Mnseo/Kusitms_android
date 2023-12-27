package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.common.ui.theme.kusimsShapes

@Composable
fun KusitmsLinkCheck() {
    Row(
        modifier = Modifier
            .width(295.dp)
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
    var isClicked by remember { mutableStateOf(false) }
//    var borderColor by remember { mutableStateOf(KusitmsColorPalette.current.White) }
    Row(
        modifier = Modifier
            .width(177.dp)
            .height(48.dp)
            .border(
                width = 1.dp,
                color = KusitmsColorPalette.current.Grey700,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = KusitmsColorPalette.current.Grey700,
                shape = RoundedCornerShape(12.dp)
            ),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(129.dp)
                .height(48.dp)
                .background(KusitmsColorPalette.current.Grey700)
                .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
        ) {
            TextField(
                value = textState.value,
                onValueChange = {
                    run { textState.value = it }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = KusitmsColorPalette.current.Main500,
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(stringResource(id = R.string.signin2_placeholder2), style = KusitmsTypo.current.Text_Medium, color = KusitmsColorPalette.current.White ) }
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
    KusitmsLinkCheck()
}