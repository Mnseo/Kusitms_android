package com.kusitms.presentation.ui.login.findPw.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.ui.ImageVector.xIcon
import kotlinx.coroutines.delay

@Composable
fun FindPwEmailComval(
    @StringRes text:Int,
    validStr: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(83.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text= stringResource(text),
            color= KusitmsColorPalette.current.Grey400,
            style = KusitmsTypo.current.Caption1,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey500,
                    shape = RoundedCornerShape(size = 16.dp)
                )
        ) {
            Text(
                text= validStr,
                color= KusitmsColorPalette.current.Grey400,
                style = KusitmsTypo.current.Text_Medium,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
            )
        }
    }


}

@Composable
fun FindPw2CodeInput(
    @StringRes text:Int,
    value:String,
    onValueChange: (String) -> Unit,
    isError:Boolean = false,
    onTimerEnd: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    val totalSeconds = remember { mutableStateOf(300) }
    val timerText = remember { mutableStateOf("") }

    LaunchedEffect(key1 = "timer") {
        while (totalSeconds.value > 0) {
            delay(1000)
            totalSeconds.value -= 1
            timerText.value = String.format("%02d:%02d", totalSeconds.value / 60, totalSeconds.value % 60)
        }
    }

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
            when {
                isFocused && value.isNotEmpty() -> {
                    IconButton(onClick = { onValueChange("") }) { Icon(imageVector = xIcon.vector, contentDescription = "Clear Text") }
                }
                isError && !isFocused -> {
                    IconButton(onClick = { }) { Icon(painter = painterResource(id = R.drawable.ic_finpw_warning), contentDescription = "warning") }
                }
            }
        }

    )
}

@Preview
@Composable
fun EmailComvalExample() {
    FindPwEmailComval(text = R.string.find_pw_caption_email, validStr = FindPwViewModel().email.toString())
}