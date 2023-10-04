package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.underArrow


@Composable
fun LinkCheckRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LinkCheckBox()
    }
}

@Composable
fun LinkCheckBox() {
    Row(
        modifier = Modifier
            .width(110.dp)
            .height(48.dp)
            .border(
                width = 1.dp,
                color = KusitmsColorPalette.current.White,
                shape = RoundedCornerShape(12.dp)
            )
            .height(48.dp)
            .background(color = KusitmsColorPalette.current.Grey700)
            .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.signin2_checkbox), style = KusitmsTypo.current.Text_Medium, color = KusitmsColorPalette.current.Grey400)
        IconButton(
            modifier=Modifier.size(24.dp),
            onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_under_errow),
                contentDescription = null,
                tint = KusitmsColorPalette.current.Grey400
            )
        }

    }
}

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



@Preview
@Composable
fun exampleRow() {
    LinkCheckRow()
}